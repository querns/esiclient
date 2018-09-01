package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Title;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Pulls titles granted to a character.
 */
final public class CharacterTitlesRequest implements GetRequest<ImmutableList<Title>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query titles
     * @param accessToken an OAuth2 access token for said character
     */
    public CharacterTitlesRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/titles/", characterID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }

    @Override
    public TypeReference<ImmutableList<Title>> getExpectedType() {
        return new TypeReference<ImmutableList<Title>>() {
        };
    }
}
