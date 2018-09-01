package gbsio.esiclient.client.request.skills;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.skills.CharacterAttributes;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves the character's attributes and information about attribute remaps.
 */
final public class CharacterAttributesRequest implements GetRequest<CharacterAttributes> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public CharacterAttributesRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/attributes/", characterID);
    }

    @Override
    public TypeReference<CharacterAttributes> getExpectedType() {
        return new TypeReference<CharacterAttributes>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
