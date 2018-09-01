package gbsio.esiclient.api.domain.response.calendar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.SenderType;
import gbsio.esiclient.internal.domain.response.calendar.CalendarEventDetailsImpl;

import java.time.ZonedDateTime;

/**
 * Represents detailed information about a calendar event.
 */
@JsonDeserialize(as = CalendarEventDetailsImpl.class)
public interface CalendarEventDetails {
    /**
     * Get the unique ID for this event.
     *
     * @return the ID
     */
    int getEventID();

    /**
     * Get the unique ID for the owner of this event.
     *
     * This information must be married with {@link #getOwnerType()} in order to
     * be useful.
     *
     * @return the ID
     */
    int getOwnerID();

    /**
     * Get the owner's name.
     *
     * @return a name
     */
    String getOwnerName();

    /**
     * Get the event's date and time.
     *
     * @return the date in UTC
     */
    ZonedDateTime getDate();

    /**
     * Get the event's title.
     *
     * @return the title
     */
    String getTitle();

    /**
     * Get the duration of the event.
     *
     * @return the duration in minutes
     */
    int getDuration();

    /**
     * Get the importance score of this event.
     *
     * @return the importance score
     */
    int getImportance();

    /**
     * Get the response that the user has assigned for this event.
     *
     * @return the response
     */
    String getResponse();

    /**
     * Get the event's body.
     *
     * @return the body
     */
    String getText();

    /**
     * Get the type of owner.
     *
     * @return the owner type
     */
    SenderType getOwnerType();
}
