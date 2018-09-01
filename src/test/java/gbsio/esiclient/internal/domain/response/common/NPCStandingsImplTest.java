package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.NPCStandings;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NPCStandingsImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<NPCStandings> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/common/npcStandings.json"),
            new TypeReference<ImmutableList<NPCStandings>>() { }
        );

        assertEquals(3, list.size());

        NPCStandings one = list.get(0);
        NPCStandings two = list.get(1);
        NPCStandings three = list.get(2);

        assertEquals(3009841, one.getID());
        assertEquals(NPCStandings.NPCType.AGENT, one.getType());
        assertEquals(0.1f, one.getStanding());

        assertEquals(1000061, two.getID());
        assertEquals(NPCStandings.NPCType.CORPORATION, two.getType());
        assertEquals(0f, two.getStanding());

        assertEquals(500003, three.getID());
        assertEquals(NPCStandings.NPCType.FACTION, three.getType());
        assertEquals(-1f, three.getStanding());
    }
}