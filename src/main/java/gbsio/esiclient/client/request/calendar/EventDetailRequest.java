package gbsio.esiclient.client.request.calendar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.calendar.CalendarEventDetails;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

final public class EventDetailRequest implements GetRequest<CalendarEventDetails> {
    private final int characterID;
    private final String accessToken;
    private final int eventID;

    public EventDetailRequest(final int characterID, final String accessToken, final int eventID) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.eventID = eventID;
    }

    @Override
    public String getURL() {
        return String.format("/v3/characters/%d/calendar/%d/", characterID, eventID);
    }

    @Override
    public TypeReference<CalendarEventDetails> getExpectedType() {
        return new TypeReference<CalendarEventDetails>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
