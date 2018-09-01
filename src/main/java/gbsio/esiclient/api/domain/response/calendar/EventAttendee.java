package gbsio.esiclient.api.domain.response.calendar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.internal.domain.response.calendar.EventAttendeeImpl;

import java.util.Optional;

/**
 * Represents an entry in a list of event attendees.
 */
@JsonDeserialize(as = EventAttendeeImpl.class)
public interface EventAttendee {
    /**
     * Get the character ID for this attendee.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     * @see CharacterInfo
     */
    Optional<Integer> getCharacterID();

    /**
     * Get the event response for this attendee.
     *
     * @return the response
     */
    Optional<EventResponseType> getEventResponse();
}
