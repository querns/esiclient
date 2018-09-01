package gbsio.esiclient.client.request.planetaryinteraction;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Colony;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about a PI colony belonging to a character.
 */
final public class ColonyRequest implements GetRequest<Colony> {
    private final int characterID;
    private final String accessToken;
    private final int planetID;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param planetID the ID of the planet where the colony is located
     */
    public ColonyRequest(final int characterID, final String accessToken, final int planetID) {
        this.characterID = characterID;
        this.planetID = planetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v3/characters/%d/planets/%d/", characterID, planetID);
    }

    @Override
    public TypeReference<Colony> getExpectedType() {
        return new TypeReference<Colony>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
