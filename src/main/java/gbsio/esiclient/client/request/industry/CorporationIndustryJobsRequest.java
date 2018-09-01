package gbsio.esiclient.client.request.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.industry.IndustryJob;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Retrieves industry jobs performed on behalf of a corporation.
 */
final public class CorporationIndustryJobsRequest implements GetListRequest<IndustryJob, ImmutableList<IndustryJob>> {
    private final int corporationID;
    private final String accessToken;
    private final boolean includeCompleted;

    /**
     * Creates a request that does not include completed jobs in the response.
     *
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    corporation with Factory Manager or Director roles
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public CorporationIndustryJobsRequest(final int corporationID, final String accessToken) {
        this(corporationID, accessToken, false);
    }

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    corporation with Factory Manager or Director roles
     * @param includeCompleted whether or not to include completed jobs in the
     *                         response
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public CorporationIndustryJobsRequest(final int corporationID, final String accessToken, final boolean includeCompleted) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.includeCompleted = includeCompleted;
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/industry/jobs/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<IndustryJob>> getExpectedType() {
        return new TypeReference<ImmutableList<IndustryJob>>() {
        };
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of("include_completed", includeCompleted);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
