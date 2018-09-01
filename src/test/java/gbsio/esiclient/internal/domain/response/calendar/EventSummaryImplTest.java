package gbsio.esiclient.internal.domain.response.calendar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.calendar.EventSummary;
import gbsio.esiclient.api.domain.response.calendar.EventResponseType;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EventSummaryImplTest {
    @Test
    void testParse() throws IOException {
        ImmutableList<EventSummary> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/calendar/calendarEventSummary.json"),
            new TypeReference<ImmutableList<EventSummary>>() { }
        );

        assertEquals(1, list.size());
        EventSummary eventSummary = list.get(0);

        assertTrue(eventSummary.getEventDate().isPresent());
        assertTrue(eventSummary.getEventID().isPresent());
        assertTrue(eventSummary.getEventResponse().isPresent());
        assertTrue(eventSummary.getImportance().isPresent());
        assertTrue(eventSummary.getTitle().isPresent());

        assertEquals(ZonedDateTime.parse("2016-06-26T20:00:00Z"), eventSummary.getEventDate().get());
        assertEquals((Integer)1386435, eventSummary.getEventID().get());
        assertEquals(EventResponseType.ACCEPTED, eventSummary.getEventResponse().get());
        assertEquals((Integer)0, eventSummary.getImportance().get());
        assertEquals("o7 The EVE Online Show", eventSummary.getTitle().get());
    }
}