package gbsio.esiclient.client.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.market.RegionalHistoricalSummary;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Map;

/**
 * Retrieves historical market statistics for an item type in a whole region.
 */
final public class RegionalHistoryRequest implements GetRequest<ImmutableList<RegionalHistoricalSummary>> {
    private final int regionID;
    private final int itemTypeID;

    /**
     * @param regionID the ID of the region to query
     * @param itemTypeID the ID of the item type to query
     */
    public RegionalHistoryRequest(final int regionID, final int itemTypeID) {
        this.regionID = regionID;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of("type_id", String.valueOf(itemTypeID));
    }

    @Override
    public String getURL() {
        return String.format("/v1/markets/%d/history/", regionID);
    }

    @Override
    public TypeReference<ImmutableList<RegionalHistoricalSummary>> getExpectedType() {
        return new TypeReference<ImmutableList<RegionalHistoricalSummary>>() {
        };
    }
}
