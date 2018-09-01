package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.market.MarketGroup;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MarketGroupImplTest {
    @Test
    void parse() throws IOException {
        MarketGroup group = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/market/marketGroup.json"),
            new TypeReference<MarketGroup>() { }
        );

        assertEquals("Small, fast vessels suited to a variety of purposes.", group.getDescription());
        assertEquals(5, group.getID());
        assertEquals("Standard Frigates", group.getName());
        assertTrue(group.getParentID().isPresent());
        assertEquals((Integer)1361, group.getParentID().get());
        assertEquals(2, group.getItemTypeIDs().size());
        assertTrue(group.getItemTypeIDs().contains(582));
        assertTrue(group.getItemTypeIDs().contains(583));
    }
}