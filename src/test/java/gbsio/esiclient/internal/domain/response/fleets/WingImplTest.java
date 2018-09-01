package gbsio.esiclient.internal.domain.response.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.fleets.Squad;
import gbsio.esiclient.api.domain.response.fleets.Wing;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WingImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Wing> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/fleets/wings.json"),
            new TypeReference<ImmutableList<Wing>>() { }
        );

        assertEquals(1, list.size());
        Wing wing = list.get(0);

        assertEquals(2073711261968L, wing.getID());
        assertEquals("Wing 1", wing.getName());
        assertEquals(1, wing.getSquads().size());

        Squad squad = wing.getSquads().get(0);
        assertEquals(3129411261968L, squad.getID());
        assertEquals("Squad 1", squad.getName());
    }
}