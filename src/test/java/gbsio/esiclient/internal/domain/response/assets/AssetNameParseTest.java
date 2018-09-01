package gbsio.esiclient.internal.domain.response.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.assets.AssetName;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssetNameParseTest {
    @Test
    void testParse() throws IOException {
        ImmutableList<AssetName> assetNamesList = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/assets/assetNames.json"),
            new TypeReference<ImmutableList<AssetName>>() { }
        );

        assertEquals(1, assetNamesList.size());
        final AssetName assetName = assetNamesList.get(0);

        assertEquals(12345, assetName.getItemID());
        assertEquals("Awesome Name", assetName.getName());

    }
}