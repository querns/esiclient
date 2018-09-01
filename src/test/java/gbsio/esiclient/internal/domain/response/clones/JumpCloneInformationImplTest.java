package gbsio.esiclient.internal.domain.response.clones;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.clones.JumpCloneInformation;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JumpCloneInformationImplTest {
    @Test
    void parse() throws IOException {
        JumpCloneInformation info = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/clones/jumpClones.json"),
            new TypeReference<JumpCloneInformation>() { }
        );

        assertTrue(info.getHomeLocation().isPresent());
        assertFalse(info.getLastCloneJumpDate().isPresent());
        assertFalse(info.getLastStationChangeDate().isPresent());

        JumpCloneInformation.HomeLocation home = info.getHomeLocation().get();
        assertTrue(home.getLocationID().isPresent());
        assertTrue(home.getLocationType().isPresent());
        assertEquals((Long)1021348135816L, home.getLocationID().get());
        assertEquals(JumpCloneInformation.LocationType.STRUCTURE, home.getLocationType().get());

        ImmutableList<JumpCloneInformation.Clone> clones = info.getJumpClones();
        assertEquals(1, clones.size());

        JumpCloneInformation.Clone clone = clones.get(0);
        assertEquals(1, clone.getImplantList().size());
        assertEquals((Integer)22118, clone.getImplantList().get(0));
        assertEquals(12345, clone.getID());
        assertEquals(60003463, clone.getLocationID());
        assertEquals(JumpCloneInformation.LocationType.STATION, clone.getLocationType());

    }
}