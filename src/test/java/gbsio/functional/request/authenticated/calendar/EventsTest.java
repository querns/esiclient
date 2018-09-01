package gbsio.functional.request.authenticated.calendar;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.calendar.CalendarEventDetails;
import gbsio.esiclient.api.domain.response.calendar.EventAttendee;
import gbsio.esiclient.api.domain.response.calendar.EventSummary;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.calendar.EventAttendeesRequest;
import gbsio.esiclient.client.request.calendar.EventDetailRequest;
import gbsio.esiclient.client.request.calendar.EventSummariesRequest;
import gbsio.esiclient.internal.Constants;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EventsTest extends FunctionalTestHarness {
    private final static ZonedDateTime EVENT_EXPIRATION_DATE = ZonedDateTime.parse("2019-08-01T00:00:00Z");
    @Test
    void request() throws IOException {
        final Client client = getClient();
        final int characterID = getPropertyAsInt("promfem_id");
        final String accessToken = getAccessToken("my_5s_token");
        final int eventID = getPropertyAsInt("event_id");

        // ------ Summaries
        final Response<ImmutableList<EventSummary>> response = client.sendRequest(
            new EventSummariesRequest(characterID, accessToken)
        ).join();

        ImmutableList<EventSummary> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
        // ------

        assertTrue(list.stream()
            .filter(eventSummary -> eventSummary.getEventID().orElse(-1) == eventID)
            .collect(Collectors.toList()).size() > 0) ;

        if (EVENT_EXPIRATION_DATE.isBefore(ZonedDateTime.now(Constants.TIMEZONE_UTC))) {
            fail("Test event has expired");
        }

        // ------ Attendees
        //noinspection OptionalGetWithoutIsPresent
        final Response<ImmutableList<EventAttendee>> attendeesResponse = client.sendRequest(new EventAttendeesRequest(
            characterID, accessToken, eventID
        )).join();

        ImmutableList<EventAttendee> attendeesList = assertResponseExistsAndGet(attendeesResponse);
        assertTrue(attendeesList.size() > 0);
        // ------

        final Response<CalendarEventDetails> detailsResponse = client.sendRequest(new EventDetailRequest(
            characterID, accessToken, eventID
        )).join();

        CalendarEventDetails details = assertResponseExistsAndGet(detailsResponse);
        assertEquals(eventID, details.getEventID());
    }
}