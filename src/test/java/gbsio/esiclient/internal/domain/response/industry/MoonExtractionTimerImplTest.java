package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.MoonExtractionTimer;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MoonExtractionTimerImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<MoonExtractionTimer> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/industry/moonExtraction.json"),
            new TypeReference<ImmutableList<MoonExtractionTimer>>() { }
        );

        assertEquals(1, list.size());
        MoonExtractionTimer timer = list.get(0);

        assertEquals(ZonedDateTime.parse("2017-10-17T11:00:59Z"), timer.getChunkArrivalDate());
        assertEquals(ZonedDateTime.parse("2017-10-11T10:37:04Z"), timer.getExtractionStartDate());
        assertEquals(40307229, timer.getMoonID());
        assertEquals(ZonedDateTime.parse("2017-10-17T14:00:59Z"), timer.getNaturalDecayDate());
        assertEquals(1000000010579L, timer.getStructureID());
    }
}