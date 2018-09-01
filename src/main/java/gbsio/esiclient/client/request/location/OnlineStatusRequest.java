package gbsio.esiclient.client.request.location;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.location.OnlineStatus;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Queries whether a character is currently online.
 */
final public class OnlineStatusRequest implements GetRequest<OnlineStatus> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token for said character
     */
    public OnlineStatusRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/online/", characterID);
    }

    @Override
    public TypeReference<OnlineStatus> getExpectedType() {
        return new TypeReference<OnlineStatus>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
