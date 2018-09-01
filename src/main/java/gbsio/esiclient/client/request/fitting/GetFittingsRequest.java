package gbsio.esiclient.client.request.fitting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.fittings.RetrievedFitting;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves the stored fits for a character.
 */
final public class GetFittingsRequest implements GetRequest<ImmutableList<RetrievedFitting>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public GetFittingsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/fittings/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<RetrievedFitting>> getExpectedType() {
        return new TypeReference<ImmutableList<RetrievedFitting>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
