package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Blueprint;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Pulls a list of a player's blueprints.
 */
final public class CharacterBlueprintsRequest implements GetListRequest<Blueprint, ImmutableList<Blueprint>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query blueprints
     * @param accessToken an OAuth2 access token for said character
     */
    public CharacterBlueprintsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/blueprints/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<Blueprint>> getExpectedType() {
        return new TypeReference<ImmutableList<Blueprint>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
