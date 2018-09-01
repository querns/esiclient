package gbsio.esiclient.client.request.opportunities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.opportunities.CompletionData;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves data about opportunities completed by a character.
 *
 * NOTE: Endpoint is bugged on the CCP side and never returns successfully.
 */
final public class CharacterOpportunitiesRequest implements GetRequest<ImmutableList<CompletionData>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public CharacterOpportunitiesRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/opportunities/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<CompletionData>> getExpectedType() {
        return new TypeReference<ImmutableList<CompletionData>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
