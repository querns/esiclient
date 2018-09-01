package gbsio.esiclient.internal.util;

import gbsio.esiclient.internal.Constants;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    @Test
    void testParseRFC7231Invalid() {
        Optional<ZonedDateTime> sut = DateParser.parseRFC7231("invalid");
        assertFalse(sut.isPresent());
    }

    @Test
    void testParseRFC7231Valid() {
        Optional<ZonedDateTime> sut = DateParser.parseRFC7231("Tue, 12 Jun 2018 17:25:48 GMT");
        ZonedDateTime date;

        assertTrue(sut.isPresent());
        date = sut.get();
        assertEquals(2, date.getDayOfWeek().getValue());
        assertEquals(12, date.getDayOfMonth());
        assertEquals(6, date.getMonthValue());
        assertEquals(2018, date.getYear());
        assertEquals(17, date.getHour());
        assertEquals(25, date.getMinute());
        assertEquals(48, date.getSecond());
        assertEquals(Constants.TIMEZONE_UTC, date.getZone());
    }
}