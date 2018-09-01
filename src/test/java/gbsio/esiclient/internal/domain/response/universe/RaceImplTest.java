package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Race;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RaceImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Race> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/race.json"),
            new TypeReference<ImmutableList<Race>>() { }
        );

        assertEquals(1, list.size());
        Race race = list.get(0);

        assertEquals(500001, race.getAllianceID());
        assertEquals("Founded on the tenets of patriotism and hard work...", race.getDescription());
        //noinspection SpellCheckingInspection
        assertEquals("Caldari", race.getName());
        assertEquals(1, race.getID());
    }
}