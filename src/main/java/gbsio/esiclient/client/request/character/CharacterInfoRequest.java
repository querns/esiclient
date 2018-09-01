package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Pulls public info about a character.
 */
final public class CharacterInfoRequest implements GetRequest<CharacterInfo> {
    private final int characterID;

    /**
     * @param characterID the ID of the character to query info
     */
    public CharacterInfoRequest(final int characterID) {
        this.characterID = characterID;
    }

    @Override
    public String getURL() {
        return String.format("/v4/characters/%d/", characterID);
    }

    @Override
    public TypeReference<CharacterInfo> getExpectedType() {
        return new TypeReference<CharacterInfo>() {
        };
    }
}
