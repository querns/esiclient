package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.ItemGroup;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemGroupImplTest {
    @Test
    void parse() throws IOException {
        ItemGroup group = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/itemGroup.json"),
            new TypeReference<ItemGroup>() { }
        );

        assertEquals(6, group.getCategoryID());
        assertEquals(25, group.getID());
        assertEquals("Frigate", group.getName());
        assertTrue(group.isPublished());
        assertEquals(3, group.getItemTypeIDs().size());
        assertTrue(group.getItemTypeIDs().containsAll(ImmutableList.of(587, 586, 585)));
    }
}