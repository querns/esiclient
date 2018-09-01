package gbsio.esiclient.internal.domain.response.calendar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.calendar.EventAttendee;
import gbsio.esiclient.api.domain.response.calendar.EventResponseType;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EventAttendeeImplTest {
    @Test
    void testParse() throws IOException {
        ImmutableList<EventAttendee> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/calendar/eventAttendee.json"),
            new TypeReference<ImmutableList<EventAttendee>>() { }
        );

        assertEquals(2, list.size());

        EventAttendee one = list.get(0);
        EventAttendee two = list.get(1);

        assertTrue(one.getCharacterID().isPresent());
        assertTrue(one.getEventResponse().isPresent());
        assertTrue(two.getCharacterID().isPresent());
        assertTrue(two.getEventResponse().isPresent());

        assertEquals((Integer)2112625428, one.getCharacterID().get());
        assertEquals(EventResponseType.ACCEPTED, one.getEventResponse().get());
        assertEquals((Integer)95465499, two.getCharacterID().get());
        assertEquals(EventResponseType.TENTATIVE, two.getEventResponse().get());
    }
}