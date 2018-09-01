package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.OwnedStructure;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OwnedStructureImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<OwnedStructure> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/ownedStructure.json"),
            new TypeReference<ImmutableList<OwnedStructure>>() { }
        );

        assertEquals(1, list.size());
        OwnedStructure structure = list.get(0);

        assertEquals(667531913, structure.getCorporationID());
        assertEquals(11237, structure.getACLProfileID());
        assertEquals(22, structure.getReinforceTimer().getHour());
        assertEquals(2, structure.getReinforceTimer().getWeekday());
        assertEquals(OwnedStructure.StructureState.SHIELD_VULNERABLE, structure.getState());
        assertEquals(1021975535893L, structure.getID());
        assertEquals(30004763, structure.getSolarSystemID());
        assertEquals(35833, structure.getItemTypeID());

        assertFalse(structure.getFuelExpiryDate().isPresent());
        assertFalse(structure.getScheduledReinforcementChange().isPresent());
        assertFalse(structure.getStateTimerStart().isPresent());
        assertFalse(structure.getStateTimerEnd().isPresent());
        assertFalse(structure.getUnanchorDate().isPresent());

        assertTrue(structure.getServices().isEmpty());
    }
}