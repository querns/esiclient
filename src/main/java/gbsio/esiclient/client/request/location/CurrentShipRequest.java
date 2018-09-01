package gbsio.esiclient.client.request.location;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.location.CurrentShip;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves the ship currently being piloted by a character.
 */
final public class CurrentShipRequest implements GetRequest<CurrentShip> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public CurrentShipRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/ship/", characterID);
    }

    @Override
    public TypeReference<CurrentShip> getExpectedType() {
        return new TypeReference<CurrentShip>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
