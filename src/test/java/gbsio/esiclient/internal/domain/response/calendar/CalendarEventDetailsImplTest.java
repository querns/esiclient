package gbsio.esiclient.internal.domain.response.calendar;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.calendar.CalendarEventDetails;
import gbsio.esiclient.api.domain.response.common.SenderType;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CalendarEventDetailsImplTest {

    private static final String LONG_TEXT = "o7: The EVE Online Show features latest developer news, fast paced action, community overviews and a lot more with CCP Guard and CCP Mimic. Join the thrilling o7 live broadcast at 20:00 EVE time (=UTC) on <a href=\"http://www.twitch.tv/ccp\">EVE TV</a>. Don't miss it!";

    @Test
    void testParse() throws IOException {
        CalendarEventDetails details = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/calendar/eventDetails.json"),
            new TypeReference<CalendarEventDetails>() { }
        );

        assertEquals(ZonedDateTime.parse("2016-06-26T21:00:00Z"), details.getDate());
        assertEquals(60, details.getDuration());
        assertEquals(1386435, details.getEventID());
        assertEquals(1, details.getImportance());
        assertEquals(1, details.getOwnerID());
        assertEquals("EVE System", details.getOwnerName());
        assertEquals(SenderType.EVE_SERVER, details.getOwnerType());
        assertEquals("Undecided", details.getResponse());
        assertEquals(LONG_TEXT, details.getText());
        assertEquals("o7 The EVE Online Show", details.getTitle());
    }
}