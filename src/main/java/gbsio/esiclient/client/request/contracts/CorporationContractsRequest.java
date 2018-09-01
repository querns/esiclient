package gbsio.esiclient.client.request.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.OwnedContract;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Requests contracts created by, accepted by, or assigned to this corporation.
 */
final public class CorporationContractsRequest implements GetListRequest<OwnedContract, ImmutableList<OwnedContract>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a director of said
     *                    corporation
     */
    public CorporationContractsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/contracts/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<OwnedContract>> getExpectedType() {
        return new TypeReference<ImmutableList<OwnedContract>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
