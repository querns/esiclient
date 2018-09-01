package gbsio.esiclient.internal.domain.response.sovereignty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Structure;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StructureImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Structure> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/sovereignty/structure.json"),
            new TypeReference<ImmutableList<Structure>>() { }
        );

        assertEquals(1, list.size());
        Structure structure = list.get(0);

        assertEquals(498125261, structure.getAllianceID());
        assertEquals(30000570, structure.getSolarSystemID());
        assertEquals(1018253388776L, structure.getID());
        assertEquals(32226, structure.getItemTypeID());

        assertTrue(structure.getActivityDefenseMultiplier().isPresent());
        assertTrue(structure.getVulnerableEndDate().isPresent());
        assertTrue(structure.getVulnerableStartDate().isPresent());
        assertEquals((Float)2F, structure.getActivityDefenseMultiplier().get());
        assertEquals(ZonedDateTime.parse("2016-10-29T05:30:00Z"), structure.getVulnerableEndDate().get());
        assertEquals(ZonedDateTime.parse("2016-10-28T20:30:00Z"), structure.getVulnerableStartDate().get());
    }
}