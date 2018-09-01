package gbsio.esiclient.client.request.dogma;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.dogma.DynamicItem;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about a dynamic item ("abyssal item").
 */
final public class DynamicItemRequest implements GetRequest<DynamicItem> {
    private final long itemID;
    private final int itemTypeID;

    /**
     * @param itemID the unique ID of the item to query
     * @param itemTypeID the ID of the type of item so queried
     */
    public DynamicItemRequest(final long itemID, final int itemTypeID) {
        this.itemID = itemID;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/dogma/dynamic/items/%d/%d/", itemTypeID, itemID);
    }

    @Override
    public TypeReference<DynamicItem> getExpectedType() {
        return new TypeReference<DynamicItem>() {
        };
    }
}
