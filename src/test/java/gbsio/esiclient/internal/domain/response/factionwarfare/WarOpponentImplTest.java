package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.WarOpponent;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarOpponentImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<WarOpponent> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/factionwarfare/warOpponent.json"),
            new TypeReference<ImmutableList<WarOpponent>>() { }
        );

        assertEquals(1, list.size());
        WarOpponent opponent = list.get(0);

        assertEquals(500002, opponent.getAgainstFactionID());
        assertEquals(500001, opponent.getFactionID());
    }
}