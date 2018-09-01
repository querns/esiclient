package gbsio.esiclient.internal.scheduling;

import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.internal.scheduling.impl.ErrorCapacityImpl;
import gbsio.esiclient.internal.util.DateParser;
import io.netty.handler.codec.http.HttpHeaders;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Describes point-in-time information about the remaining capacity for causing
 * ESI errors.
 */
public interface ErrorCapacity {
    /**
     * Constructs an instance from HTTP headers.
     *
     * @param headers headers from an HTTP response
     * @return an instance of ErrorCapacity, or missing if the date is missing
     * or malformed
     */
    static Optional<ErrorCapacity> from(HttpHeaders headers) {
        String dateString = headers.get(Constants.DATE_HEADER);
        Optional<ZonedDateTime> date;

        if (null == dateString) {
            return Optional.empty();
        }

        date = DateParser.parseRFC7231(dateString);

        if (headers.contains(Constants.REMAINING_ERROR_LIMIT_HEADER)
                && headers.contains(Constants.ERROR_LIMIT_RESET_HEADER)
                && date.isPresent()) {
            try {
                return Optional.of(new ErrorCapacityImpl(
                    Integer.parseInt(headers.get(Constants.REMAINING_ERROR_LIMIT_HEADER)),
                    date.get(),
                    Integer.parseInt(headers.get(Constants.ERROR_LIMIT_RESET_HEADER))
                ));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    /**
     * Gets the remaining error capacity for this window.
     *
     * @return the remaining error capacity
     */
    int getRemainingCapacity();

    /**
     * Gets the date that the error capacity was created.
     *
     * @return the date
     */
    ZonedDateTime getGenerationDate();

    /**
     * Gets the date that the error capacity resets.
     *
     * @return the reset date
     */
    ZonedDateTime getResetDate();

    /**
     * Gets the number of seconds left in the current error window.
     *
     * @return 1 or more seconds
     */
    int getSecondsUntilCapacityReset();
}
