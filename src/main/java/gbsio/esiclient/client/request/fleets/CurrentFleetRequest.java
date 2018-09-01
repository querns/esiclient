package gbsio.esiclient.client.request.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.fleets.CurrentFleet;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about the fleet that the character is currently in.
 */
final public class CurrentFleetRequest implements GetRequest<CurrentFleet> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token for said character
     */
    public CurrentFleetRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/fleet/", characterID);
    }

    @Override
    public TypeReference<CurrentFleet> getExpectedType() {
        return new TypeReference<CurrentFleet>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
