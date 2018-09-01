package gbsio.esiclient.internal.domain.response.wars;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.wars.PrimaryParty;
import gbsio.esiclient.api.domain.response.wars.War;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarImplTest {
    @Test
    void parse() throws IOException {
        War war = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/war/war.json"),
            new TypeReference<War>() { }
        );

        PrimaryParty aggressor = war.getAggressor();
        PrimaryParty defender = war.getDefender();

        assertEquals(0, aggressor.getISKDestroyed());
        assertEquals(0, aggressor.getShipKillCount());
        assertTrue(aggressor.getCorporationID().isPresent());
        assertEquals((Integer)986665792, aggressor.getCorporationID().get());

        assertEquals(ZonedDateTime.parse("2004-05-22T05:20:00Z"), war.getDeclarationDate());

        assertEquals(0, defender.getShipKillCount());
        assertEquals(0, defender.getISKDestroyed());
        assertTrue(defender.getCorporationID().isPresent());
        assertEquals((Integer)1001562011, defender.getCorporationID().get());

        assertEquals(1941, war.getID());
        assertFalse(war.isMutual());
        assertFalse(war.isAcceptingAllies());

        assertFalse(war.getFinishDate().isPresent());
        assertFalse(war.getRetractDate().isPresent());
        assertFalse(war.getStartDate().isPresent());
    }
}