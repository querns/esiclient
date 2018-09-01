package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.MemberTrackingData;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MemberTrackingDataImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<MemberTrackingData> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/memberTracking.json"),
            new TypeReference<ImmutableList<MemberTrackingData>>() {
            }
        );

        assertEquals(2, list.size());

        MemberTrackingData one = list.get(0);
        MemberTrackingData two = list.get(1);

        assertEquals(2112000001, one.getCharacterID());
        assertTrue(one.getLocationID().isPresent());
        assertTrue(one.getLogoffDate().isPresent());
        assertTrue(one.getLoginDate().isPresent());
        assertTrue(one.getShipTypeID().isPresent());
        assertTrue(one.getStartDate().isPresent());
        assertEquals((Long)30003657L, one.getLocationID().get());
        assertEquals(ZonedDateTime.parse("2017-08-03T14:31:16Z"), one.getLogoffDate().get());
        assertEquals(ZonedDateTime.parse("2017-08-03T14:22:03Z"), one.getLoginDate().get());
        assertEquals((Integer)22464, one.getShipTypeID().get());
        assertEquals(ZonedDateTime.parse("2017-07-10T14:46:00Z"), one.getStartDate().get());

        assertEquals(2112000002, two.getCharacterID());
        assertTrue(two.getLocationID().isPresent());
        assertTrue(two.getLogoffDate().isPresent());
        assertTrue(two.getLoginDate().isPresent());
        assertTrue(two.getShipTypeID().isPresent());
        assertTrue(two.getStartDate().isPresent());
        assertEquals((Long)30003657L, two.getLocationID().get());
        assertEquals(ZonedDateTime.parse("2017-07-25T11:07:40Z"), two.getLogoffDate().get());
        assertEquals(ZonedDateTime.parse("2017-07-25T10:54:00Z"), two.getLoginDate().get());
        assertEquals((Integer)670, two.getShipTypeID().get());
        assertEquals(ZonedDateTime.parse("2017-07-10T14:50:00Z"), two.getStartDate().get());
    }
}