package gbsio.esiclient.client.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.market.RegionalOrder;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Map;

/**
 * Retrieves a list of market orders in NPC structures in a region.
 */
final public class RegionalOrdersRequest implements GetListRequest<RegionalOrder, ImmutableList<RegionalOrder>> {
    private final int regionID;
    private final OrderType orderType;
    private final Integer itemTypeID;

    /**
     * Creates a request for a specific item and the specified subset of order
     * types.
     *
     * @param regionID the ID of the region to query
     * @param orderType the type of order (buy, sell, or all)
     * @param itemTypeID the ID of the item type to query
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public RegionalOrdersRequest(final int regionID, final OrderType orderType, final Integer itemTypeID) {
        this.regionID = regionID;
        this.orderType = orderType;
        this.itemTypeID = itemTypeID;
    }

    /**
     * Creates a request for all orders in a region of the specified subset of
     * order types.
     *
     * @param regionID the ID of the region to query
     * @param orderType the type of order (buy, sell, or all)
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public RegionalOrdersRequest(final int regionID, final OrderType orderType) {
        this(regionID, orderType, null);
    }

    /**
     * Creates a request for all orders in a region of the specified item type.
     * @param regionID the ID of the region to query
     * @param itemTypeID the ID of the item type to query
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public RegionalOrdersRequest(final int regionID, final Integer itemTypeID) {
        this(regionID, OrderType.ALL, itemTypeID);
    }

    /**
     * Creates a request for all orders in a region.
     *
     * @param regionID the ID of the region to query
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public RegionalOrdersRequest(final int regionID) {
        this(regionID, OrderType.ALL, null);
    }

    @Override
    public String getURL() {
        return String.format("/v1/markets/%d/orders/", regionID);
    }

    @Override
    public TypeReference<ImmutableList<RegionalOrder>> getExpectedType() {
        return new TypeReference<ImmutableList<RegionalOrder>>() {
        };
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        final ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();

        builder.put("order_type", orderType.getType());
        if (null != itemTypeID) {
            builder.put("type_id", String.valueOf(itemTypeID));
        }

        return builder.build();
    }

    public enum OrderType {
        BUY("buy"), SELL("sell"), ALL("all");

        private final String type;
        OrderType(final String type) {
            this.type = type;
        }

        private String getType() {
            return type;
        }
    }
}
