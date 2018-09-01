package gbsio.esiclient.internal.domain.response.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.calendar.EventAttendee;
import gbsio.esiclient.api.domain.response.calendar.EventResponseType;

import java.util.Optional;

public class EventAttendeeImpl implements EventAttendee {
    private final Integer characterID;
    private final EventResponseType responseType;

    EventAttendeeImpl(
        @JsonProperty("character_id")
        final Integer characterID,
        @JsonProperty("event_response")
        final EventResponseType responseType
    ) {
        this.characterID = characterID;
        this.responseType = responseType;
    }

    @Override
    public Optional<Integer> getCharacterID() {
        return Optional.ofNullable(characterID);
    }

    @Override
    public Optional<EventResponseType> getEventResponse() {
        return Optional.ofNullable(responseType);
    }

}
