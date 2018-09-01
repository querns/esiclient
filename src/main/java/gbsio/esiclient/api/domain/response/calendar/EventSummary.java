package gbsio.esiclient.api.domain.response.calendar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.calendar.EventSummaryImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents summary information about a calendar event.
 */
@JsonDeserialize(as = EventSummaryImpl.class)
public interface EventSummary {
    /**
     * Gets the date of the event.
     *
     * @return a date in GMT
     */
    Optional<ZonedDateTime> getEventDate();

    /**
     * Gets the unique ID for this event.
     *
     * @return the ID
     */
    Optional<Integer> getEventID();

    /**
     * Gets the event response.
     *
     * @return an event response.
     */
    Optional<EventResponseType> getEventResponse();

    /**
     * Gets the importance score of this event.
     *
     * @return the importance score
     */
    Optional<Integer> getImportance();

    /**
     * Get this event's title.
     *
     * @return the title
     */
    Optional<String> getTitle();
}
