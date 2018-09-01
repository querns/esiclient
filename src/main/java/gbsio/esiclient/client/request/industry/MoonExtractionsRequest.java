package gbsio.esiclient.client.request.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.MoonExtractionTimer;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves scheduling information for upcoming moon extractions at corporate
 * facilities.
 */
final public class MoonExtractionsRequest implements GetListRequest<MoonExtractionTimer, ImmutableList<MoonExtractionTimer>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    corporation with Structure Manager or Director roles
     */
    public MoonExtractionsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporation/%d/mining/extractions/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<MoonExtractionTimer>> getExpectedType() {
        return new TypeReference<ImmutableList<MoonExtractionTimer>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
