package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CorporationHistoryEntry;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CorporationHistoryEntryImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<CorporationHistoryEntry> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/corporationHistory.json"),
            new TypeReference<ImmutableList<CorporationHistoryEntry>>() { }
        );

        assertEquals(2, list.size());
        CorporationHistoryEntry one = list.get(0);
        CorporationHistoryEntry two = list.get(1);

        assertEquals(90000001, one.getCorporationID());
        assertTrue(one.isDeleted().isPresent());
        assertTrue(one.isDeleted().get());
        assertEquals(500, one.getRecordID());
        assertEquals(ZonedDateTime.parse("2016-06-26T20:00:00Z"), one.getStartDate());

        assertEquals(90000002, two.getCorporationID());
        assertFalse(two.isDeleted().isPresent());
        assertEquals(501, two.getRecordID());
        assertEquals(ZonedDateTime.parse("2016-07-26T20:00:00Z"), two.getStartDate());
    }
}