package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.NPCStandings;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Pulls a character's standings towards NPCs.
 */
final public class CharacterStandingsRequest implements GetRequest<ImmutableList<NPCStandings>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query NPC standings
     * @param accessToken an OAuth2 access token for said character
     */
    public CharacterStandingsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/standings/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<NPCStandings>> getExpectedType() {
        return new TypeReference<ImmutableList<NPCStandings>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
