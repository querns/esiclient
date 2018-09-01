package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.AllianceHistory;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AllianceHistoryImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<AllianceHistory> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/allianceHistory.json"),
            new TypeReference<ImmutableList<AllianceHistory>>() { }
        );

        assertEquals(2, list.size());

        AllianceHistory one = list.get(0);
        AllianceHistory two = list.get(1);

        assertTrue(one.getAllianceID().isPresent());
        assertTrue(one.isDeleted().isPresent());
        assertEquals((Integer)99000006, one.getAllianceID().get());
        assertTrue(one.isDeleted().get());
        assertEquals(ZonedDateTime.parse("2016-10-25T14:46:00Z"), one.getStartDate());
        assertEquals(23, one.getRecordID());

        assertEquals(1, two.getRecordID());
        assertEquals(ZonedDateTime.parse("2015-07-06T20:56:00Z"), two.getStartDate());
        assertFalse(two.getAllianceID().isPresent());
        assertFalse(two.isDeleted().isPresent());
    }
}