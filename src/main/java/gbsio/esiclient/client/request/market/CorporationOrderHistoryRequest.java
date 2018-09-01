package gbsio.esiclient.client.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.CorporationOrder;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Gets cancelled and expired market orders belonging to a corporation up to 90
 * days in the past.
 */
final public class CorporationOrderHistoryRequest implements GetListRequest<CorporationOrder, ImmutableList<CorporationOrder>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character with
     *                    the Accountant, Trader, or Director role
     */
    public CorporationOrderHistoryRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/corporations/%d/orders/history/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<CorporationOrder>> getExpectedType() {
        return new TypeReference<ImmutableList<CorporationOrder>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
