package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.CorporationMedal;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CorporationMedalImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<CorporationMedal> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/medals.json"),
            new TypeReference<ImmutableList<CorporationMedal>>() { }
        );

        assertEquals(1, list.size());
        CorporationMedal medal = list.get(0);
        assertEquals(ZonedDateTime.parse("2017-10-10T14:00:00Z"), medal.getCreatedAt());
        assertEquals(46578, medal.getCreatorID());
        assertEquals("An Awesome Medal", medal.getDescription());
        assertEquals(123, medal.getMedalID());
        assertEquals("Awesome Medal", medal.getTitle());
    }
}