package gbsio.esiclient.internal.domain.response.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.assets.Asset;
import gbsio.esiclient.api.domain.response.assets.LocationType;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssetParseTest {
    @Test
    void testParseWithBPCCopy() throws IOException {
        final String resourceLocation = "json/domain/assets/assetWithBPCCopyFlag.json";

        Asset asset = getAsset(resourceLocation);
        assertTrue(asset.isBlueprintCopy().isPresent());
        assertTrue(asset.isBlueprintCopy().get());
        assertCommonAssetProperties(asset);
    }

    @Test
    void testParseWithoutBPCCopy() throws IOException {
        final String resourceLocation = "json/domain/assets/assetWithoutBPCCopyFlag.json";

        Asset asset = getAsset(resourceLocation);
        assertCommonAssetProperties(asset);
    }

    private Asset getAsset(String resourceLocation) throws IOException {
        ImmutableList<Asset> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream(resourceLocation),
            new TypeReference<ImmutableList<Asset>>() { }
        );

        assertEquals(1, list.size());
        return list.get(0);
    }

    private void assertCommonAssetProperties(Asset asset) {
        assertTrue(asset.isSingleton());
        assertEquals(1000000016835L, asset.getItemID());
        assertEquals("Hangar", asset.getLocationFlag());
        assertEquals(60002959, asset.getLocationID());
        assertEquals(LocationType.of("station"), asset.getLocationType());
        assertEquals(1, asset.getQuantity());
        assertEquals(3516, asset.getItemTypeID());
    }
}