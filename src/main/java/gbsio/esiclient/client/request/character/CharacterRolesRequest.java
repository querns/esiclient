package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.character.CharacterRoles;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Pulls the corporation roles for a character.
 */
final public class CharacterRolesRequest implements GetRequest<CharacterRoles> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query corporation roles
     * @param accessToken an OAuth2 access token for said character
     */
    public CharacterRolesRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/roles/", characterID);
    }

    @Override
    public TypeReference<CharacterRoles> getExpectedType() {
        return new TypeReference<CharacterRoles>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
