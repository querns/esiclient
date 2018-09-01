package gbsio.esiclient.internal.domain.response.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.assets.AssetLocation;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssetLocationParseTest {
    @Test
    void testParse() throws IOException {
        final ImmutableList<AssetLocation> locations = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/assets/assetLocations.json"),
            new TypeReference<ImmutableList<AssetLocation>>() { }
        );

        assertEquals(1, locations.size());
        final AssetLocation assetLocation = locations.get(0);

        assertEquals(12345, assetLocation.getItemID());
        assertEquals(1.2, assetLocation.getPosition().getX());
        assertEquals(2.3, assetLocation.getPosition().getY());
        assertEquals(-3.4, assetLocation.getPosition().getZ());
    }
}