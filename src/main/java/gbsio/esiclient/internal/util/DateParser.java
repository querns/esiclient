package gbsio.esiclient.internal.util;

import com.ethlo.time.ITU;
import gbsio.esiclient.internal.Constants;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

/**
 * Parses dates from various string formats.
 */
final public class DateParser {
    @SuppressWarnings("SpellCheckingInspection")
    private static final DateTimeFormatter RFC_7231_FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz");

    /**
     * Parses a string containing an RFC 7231 date.
     *
     * @param dateString the string to be parsed
     * @return the parsed date in the UTC time zone, or empty if the string
     * could not be parsed
     */
    static public Optional<ZonedDateTime> parseRFC7231(String dateString) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateString, RFC_7231_FORMAT);

            return Optional.of(ZonedDateTime.of(dateTime, Constants.TIMEZONE_UTC));
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }

    static public ZonedDateTime parseRFC3339(String dateString) throws DateTimeParseException {
        return ITU.parseDateTime(dateString).toZonedDateTime();
    }
}
