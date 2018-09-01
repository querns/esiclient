package gbsio.esiclient.client.request.planetaryinteraction;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.ColonySummary;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves planetary colonies belonging to a character.
 */
final public class ColonySummariesRequest implements GetRequest<ImmutableList<ColonySummary>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public ColonySummariesRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/planets/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<ColonySummary>> getExpectedType() {
        return new TypeReference<ImmutableList<ColonySummary>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
