package gbsio.esiclient.client.request.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.factionwarfare.CharacterStats;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieve stats about a character enrolled in faction warfare.
 */
final public class CharacterStatsRequest implements GetRequest<CharacterStats> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public CharacterStatsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/fw/stats/", characterID);
    }

    @Override
    public TypeReference<CharacterStats> getExpectedType() {
        return new TypeReference<CharacterStats>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
