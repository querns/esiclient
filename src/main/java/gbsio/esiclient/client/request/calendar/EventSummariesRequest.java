package gbsio.esiclient.client.request.calendar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.calendar.EventSummary;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Gets summary information about calendar events for a character.
 */
final public class EventSummariesRequest implements GetRequest<ImmutableList<EventSummary>> {
    private final int characterID;
    private final String accessToken;
    private final ImmutableMap<String, Object> queryParameters;

    /**
     * Requests up to 50 event summaries, starting with the soonest occurring.
     *
     * @param characterID the ID of the character whose events are requested
     * @param accessToken the access token for this character
     */
    public EventSummariesRequest(int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.queryParameters = ImmutableMap.of();
    }

    /**
     * Requests up to 50 event summaries, starting after the indicated event.
     *  @param characterID the ID of the character whose events are requested
     * @param accessToken the access token for this event
     * @param fromEventID the ID of the event marking from when the next events
     */
    public EventSummariesRequest(int characterID, final String accessToken, int fromEventID) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.queryParameters = ImmutableMap.of("from_event", fromEventID);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/calendar/", characterID);
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return queryParameters;
    }

    @Override
    public TypeReference<ImmutableList<EventSummary>> getExpectedType() {
        return new TypeReference<ImmutableList<EventSummary>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
