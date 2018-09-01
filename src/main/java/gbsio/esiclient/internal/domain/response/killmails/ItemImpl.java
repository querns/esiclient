package gbsio.esiclient.internal.domain.response.killmails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.killmails.Item;

import java.util.Optional;

public class ItemImpl implements Item {
    private final int flag;
    private final int itemTypeID;
    private final ImmutableList<Item> containedItems;
    private final Long quantityDestroyed;
    private final Long quantityDropped;
    private final int singleton;

    ItemImpl(
        @JsonProperty(value = "flag", required = true)
        final int flag,
        @JsonProperty(value = "item_type_id", required = true)
        final int itemTypeID,
        @JsonProperty("items")
        final ImmutableList<Item> containedItems,
        @JsonProperty("quantity_destroyed")
        final Long quantityDestroyed,
        @JsonProperty("quantity_dropped")
        final Long quantityDropped,
        @JsonProperty(value = "singleton", required = true)
        final int singleton
    ) {
        this.flag = flag;
        this.itemTypeID = itemTypeID;
        this.containedItems = MoreObjects.firstNonNull(containedItems, ImmutableList.of());
        this.quantityDestroyed = quantityDestroyed;
        this.quantityDropped = quantityDropped;
        this.singleton = singleton;
    }

    @Override
    public int getFlag() {
        return flag;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }

    @Override
    public ImmutableList<Item> getContainedItems() {
        return containedItems;
    }

    @Override
    public Optional<Long> getQuantityDestroyed() {
        return Optional.ofNullable(quantityDestroyed);
    }

    @Override
    public Optional<Long> getQuantityDropped() {
        return Optional.ofNullable(quantityDropped);
    }

    @Override
    public int getSingleton() {
        return singleton;
    }
}
