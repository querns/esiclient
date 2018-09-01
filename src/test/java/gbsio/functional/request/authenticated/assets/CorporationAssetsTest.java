package gbsio.functional.request.authenticated.assets;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.assets.Asset;
import gbsio.esiclient.api.domain.response.assets.AssetLocation;
import gbsio.esiclient.api.domain.response.assets.AssetName;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.assets.CorporationAssetLocationsRequest;
import gbsio.esiclient.client.request.assets.CorporationAssetNamesRequest;
import gbsio.esiclient.client.request.assets.CorporationAssetsRequest;
import gbsio.esiclient.internal.util.ImmutableListCollector;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CorporationAssetsTest extends FunctionalTestHarness {
    private static final int ATHANOR_ITEM_TYPE_ID = 35835;

    @BeforeAll
    static void setUp() throws IOException {
    }

    @Test
    void request() throws IOException {
        final int corporationID = getPropertyAsInt("goonwaffe_id");
        final String accessToken = getAccessToken("goonwaffe_token");
        final Client client = getClient();

        // ------ Assets
        final Response<ImmutableList<Asset>> response = client.sendRequest(
            new CorporationAssetsRequest(corporationID, accessToken)
        ).join();

        final ImmutableList<Asset> assets = assertResponseExistsAndGet(response);
        assertTrue(assets.size() > 0);
        // ------ Assets

        // Filter the assets down to only deployed athanors and get their item IDs
        final ImmutableList<Long> assetIDSubset = assets.stream()
            .filter(Asset::isSingleton)
            .filter(asset -> asset.getItemTypeID() == ATHANOR_ITEM_TYPE_ID)
            .map(Asset::getItemID)
            .collect(new ImmutableListCollector<>())
            ;

        assertNotNull(assetIDSubset);
        assertTrue(assetIDSubset.size() > 0);

        // ------ Asset Names
        final Response<ImmutableList<AssetName>> namesResponse = client.sendRequest(
            new CorporationAssetNamesRequest(
                corporationID,
                accessToken,
                assetIDSubset.subList(0, Integer.min(1000, assetIDSubset.size())))
        ).join();

        final ImmutableList<AssetName> assetNames = assertResponseExistsAndGet(namesResponse);
        assertTrue(assetNames.size() > 0);
        // ------ Asset Names

        // ------ Asset Locations
        final Response<ImmutableList<AssetLocation>> locationsResponse = client.sendRequest(
            new CorporationAssetLocationsRequest(
                corporationID, accessToken, assetIDSubset.subList(0, Integer.min(1000, assetIDSubset.size()))
            )
        ).join();

        final ImmutableList<AssetLocation> assetLocations = assertResponseExistsAndGet(locationsResponse);
        assertTrue(assetLocations.size() > 0);
        // ------ Asset Locations
    }
}