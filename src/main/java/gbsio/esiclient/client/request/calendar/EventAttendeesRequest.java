package gbsio.esiclient.client.request.calendar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.calendar.EventAttendee;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

final public class EventAttendeesRequest implements GetRequest<ImmutableList<EventAttendee>> {
    private final int characterID;
    private final String accessToken;
    private final int eventID;

    /**
     * @param characterID the ID of the character whose bookmarks are desired
     * @param accessToken an OAuth2 access token for said character
     * @param eventID the ID of an event
     * @see EventSummariesRequest
     */
    public EventAttendeesRequest(final int characterID, final String accessToken, final int eventID) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.eventID = eventID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/calendar/%d/attendees/", characterID, eventID);
    }

    @Override
    public TypeReference<ImmutableList<EventAttendee>> getExpectedType() {
        return new TypeReference<ImmutableList<EventAttendee>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
