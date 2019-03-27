package gbsio.functional.request.authenticated.assets;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.assets.Asset;
import gbsio.esiclient.api.domain.response.assets.AssetLocation;
import gbsio.esiclient.api.domain.response.assets.AssetName;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.assets.CharacterAssetLocationsRequest;
import gbsio.esiclient.client.request.assets.CharacterAssetNamesRequest;
import gbsio.esiclient.client.request.assets.CharacterAssetsRequest;
import gbsio.esiclient.internal.util.ImmutableListCollector;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterAssetsTest extends FunctionalTestHarness {
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    void request() throws IOException {
        final int characterID = getPropertyAsInt("querns_id");
        final String accessToken =
                "eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVC1TaWduYXR1cmUtS2V5IiwidHlwIjoiSldUIn0.eyJzY3AiOlsiZXNpLWFzc2V0cy5yZWFkX2Fzc2V0cy52MSIsImVzaS1za2lsbHMucmVhZF9za2lsbHMudjEiLCJlc2ktY2hhcmFjdGVycy5yZWFkX3N0YW5kaW5ncy52MSIsImVzaS1za2lsbHMucmVhZF9za2lsbHF1ZXVlLnYxIiwiZXNpLWNvbnRyYWN0cy5yZWFkX2NoYXJhY3Rlcl9jb250cmFjdHMudjEiLCJlc2ktdW5pdmVyc2UucmVhZF9zdHJ1Y3R1cmVzLnYxIiwiZXNpLWxvY2F0aW9uLnJlYWRfbG9jYXRpb24udjEiLCJlc2ktdWkub3Blbl93aW5kb3cudjEiLCJlc2ktY29udHJhY3RzLnJlYWRfY29ycG9yYXRpb25fY29udHJhY3RzLnYxIiwiZXNpLXVpLndyaXRlX3dheXBvaW50LnYxIiwiZXNpLXdhbGxldC5yZWFkX2NoYXJhY3Rlcl93YWxsZXQudjEiLCJlc2ktaW5kdXN0cnkucmVhZF9jaGFyYWN0ZXJfam9icy52MSJdLCJqdGkiOiI3MTg2MTNkNC05YjNkLTRlMDAtODFhYS0wMThiNDk0M2Y1Y2QiLCJraWQiOiJKV1QtU2lnbmF0dXJlLUtleSIsInN1YiI6IkNIQVJBQ1RFUjpFVkU6OTUwODUxNjIiLCJhenAiOiJjZGQzYWVjZTVjNTY0NmJhODdiMjE0OTk5MDUwZmE5NiIsIm5hbWUiOiJTaGl0YW5rbydzIFNjcmFweWFyZCIsIm93bmVyIjoiY2kwZlFIVVU4cnUrMGw3WDZrblU5M3lGTDN3PSIsImV4cCI6MTUzNjgzNTY5MCwiaXNzIjoibG9naW4uZXZlb25saW5lLmNvbSJ9.HANXvZljkQeSCogdZa0Rh_rQ61osrMcMXRiIMTp_lXvtIDdA9usvgte3pjrZmp3d84HB705Wm9W3C4IaPAHrjmoevM5EOiRLiMyG7daZl5XUuIZwZ_bjalOCHiWH4fQTo44ot96-8gaSV11NEfU8XWc9y2eQuaIo2lsOXINNxLC6seiayXl464Wag0xfp4E2Wx4-1jhzrLdd8bbQlPjSxgWpDzEicXfAKRnb-1ICGSp1kCAtan9iXwmD81f-BRQVOJoFBtPB1CedSh9yYDouuDujkFeCcFroIccSMyb9oTKa-YtHScjGoEXyyEDDMJVSLq7AG42d9vF43Jq_UDn-nQ";
        //getAccessToken("querns_token");
        final Client client = getClient();
        final int clawTypeID = getPropertyAsInt("claw_item_type_id");

        // ------ Assets
        final CharacterAssetsRequest request = new CharacterAssetsRequest(
            characterID,
            accessToken
        );

        final Response<ImmutableList<Asset>> response = client.sendRequest(request).join();
        final ImmutableList<Asset> assets = assertResponseExistsAndGet(response);

        assertTrue(assets.size() > 0);
//        log(String.format("Total number of assets: %d", assets.size()));
        // ------ Assets

        // Filter the assets down to only claws and get their item IDs
        final ImmutableList<Long> assetIDSubset = assets.stream()
            .filter(Asset::isSingleton)
            .filter(asset -> asset.getItemTypeID() == clawTypeID)
            .map(Asset::getItemID)
            .collect(new ImmutableListCollector<>())
            ;

        assertNotNull(assetIDSubset);
        assertTrue(assetIDSubset.size() > 0);

        // ------ Asset Names
        final Response<ImmutableList<AssetName>> namesResponse = client.sendRequest(
            new CharacterAssetNamesRequest(
                characterID,
                accessToken,
                assetIDSubset.subList(0, Integer.min(1000, assetIDSubset.size())))
        ).join();

        final ImmutableList<AssetName> assetNames = assertResponseExistsAndGet(namesResponse);
        assertTrue(assetNames.size() > 0);
//        log(String.format("Total number of asset names: %d", assetNames.size()));
        // ------ Asset Names

        // ------ Asset Locations
        final Response<ImmutableList<AssetLocation>> locationsResponse = client.sendRequest(
            new CharacterAssetLocationsRequest(
                characterID, accessToken, assetIDSubset.subList(0, Integer.min(1000, assetIDSubset.size()))
            )
        ).join();

        final ImmutableList<AssetLocation> assetLocations = assertResponseExistsAndGet(locationsResponse);
        assertTrue(assetLocations.size() > 0);
//        log(String.format("Total number of asset locations: %d", assetLocations.size()));
        // ------ Asset Locations
    }
}