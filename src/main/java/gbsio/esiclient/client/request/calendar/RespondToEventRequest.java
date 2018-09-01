package gbsio.esiclient.client.request.calendar;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.calendar.EventResponseType;
import gbsio.esiclient.api.request.specific.PutRequest;

import java.util.Optional;

/**
 * A request to respond to a calendar event.
 */
final public class RespondToEventRequest implements PutRequest {
    private final int characterID;
    private final String accessToken;
    private final int eventID;
    private final EventResponseType responseType;

    /**
     * Creates a new request for setting the response to an event.
     *
     * @param characterID the ID of the character whose event is receiving a
     *                   response
     * @param accessToken the authentication token for characterID
     * @param eventID the ID of the event that is receiving a response
     * @param responseType the type of response
     * @throws IllegalArgumentException if responseType is
     *                                  {@link EventResponseType#UNKNOWN} or
     *                                  null
     */
    public RespondToEventRequest(final int characterID, final String accessToken, final int eventID, final EventResponseType responseType) {
        if (EventResponseType.UNKNOWN == Preconditions.checkNotNull(responseType)) {
            throw new IllegalArgumentException("Third argument to ResponseToEventRequest() cannot be EventResponseType.UNKNOWN");
        }

        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.eventID = eventID;
        this.responseType = responseType;
    }

    @Override
    public String getURL() {
        return String.format("/v3/characters/%d/calendar/%d/", characterID, eventID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(ImmutableMap.of("response", responseType.getIdentifier()));
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
