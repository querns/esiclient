package gbsio.esiclient.client.request.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.MiningObserver;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves a list of entities that are observing mining activity taking place
 * at corporate facilities.
 */
final public class MiningObserverRequest implements GetRequest<ImmutableList<MiningObserver>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a member of said
     *                    corporation with Accountant or Director roles
     */
    public MiningObserverRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporation/%d/mining/observers/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<MiningObserver>> getExpectedType() {
        return new TypeReference<ImmutableList<MiningObserver>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
