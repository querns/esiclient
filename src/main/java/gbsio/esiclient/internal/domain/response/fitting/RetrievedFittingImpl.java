package gbsio.esiclient.internal.domain.response.fitting;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.fittings.RetrievedFitting;
import gbsio.esiclient.api.domain.common.fittings.Item;

public class RetrievedFittingImpl implements RetrievedFitting {
    private final String description;
    private final int ID;
    private final ImmutableList<Item> items;
    private final String name;
    private final int shipItemTypeID;

    RetrievedFittingImpl(
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty(value = "fitting_id", required = true)
        final int id,
        @JsonProperty(value = "items", required = true)
        final ImmutableList<Item> items,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "ship_type_id", required = true)
        final int shipItemTypeID
    ) {
        this.description = description;
        ID = id;
        this.items = MoreObjects.firstNonNull(items, ImmutableList.of());
        this.name = name;
        this.shipItemTypeID = shipItemTypeID;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public ImmutableList<Item> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getShipItemTypeID() {
        return shipItemTypeID;
    }
}
