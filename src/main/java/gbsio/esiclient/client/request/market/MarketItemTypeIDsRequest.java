package gbsio.esiclient.client.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetListRequest;

/**
 * Gets item type IDs with active market orders in the specified region.
 */
final public class MarketItemTypeIDsRequest implements GetListRequest<Integer, ImmutableList<Integer>> {
    private final int regionID;

    /**
     * @param regionID the ID of the region to query
     */
    public MarketItemTypeIDsRequest(final int regionID) {
        this.regionID = regionID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/markets/%d/types/", regionID);
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }
}
