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
        final String accessToken = getAccessToken("querns_token");
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