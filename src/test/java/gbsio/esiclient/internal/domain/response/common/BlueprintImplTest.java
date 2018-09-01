package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Blueprint;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BlueprintImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<Blueprint> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/common/blueprint.json"),
            new TypeReference<ImmutableList<Blueprint>>() { }
        );

        assertEquals(1, list.size());
        Blueprint blueprint = list.get(0);

        assertEquals(1000000010495L, blueprint.getItemID());
        assertEquals("Hangar", blueprint.getLocationFlag());
        assertEquals(60014719, blueprint.getLocationID());
        assertEquals(0, blueprint.getMaterialEfficiency());
        assertEquals(1, blueprint.getQuantity());
        assertEquals(-1, blueprint.getRuns());
        assertEquals(0, blueprint.getTimeEfficiency());
        assertEquals(691, blueprint.getItemTypeID());
    }
}