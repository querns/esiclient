package gbsio.esiclient.client.request.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.ObservedMiningData;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Returns data about mining that took place at a single corporation facility.
 */
final public class ObservedMiningDataRequest implements GetListRequest<ObservedMiningData, ImmutableList<ObservedMiningData>> {
    private final int corporationID;
    private final String accessToken;
    private final long observerID;

    /**
     * @param corporationID the ID of the corporation possessing the observer
     * @param accessToken an OAuth2 access token belonging to a member of said
     *                    corporation with Accountant or Director roles
     * @param observerID the ID of said observer
     */
    public ObservedMiningDataRequest(final int corporationID, final String accessToken, final long observerID) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.observerID = observerID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporation/%d/mining/observers/%d/", corporationID, observerID);
    }

    @Override
    public TypeReference<ImmutableList<ObservedMiningData>> getExpectedType() {
        return new TypeReference<ImmutableList<ObservedMiningData>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
