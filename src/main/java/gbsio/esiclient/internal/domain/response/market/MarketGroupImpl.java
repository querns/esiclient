package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.MarketGroup;

import java.util.Optional;

public class MarketGroupImpl implements MarketGroup {
    private final String description;
    private final int ID;
    private final String name;
    private final Integer parentID;
    private final ImmutableList<Integer> itemTypeIDs;

    MarketGroupImpl(
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty(value = "market_group_id", required = true)
        final int id,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty("parent_group_id")
        final Integer parentID,
        @JsonProperty(value = "types", required = true)
        final ImmutableList<Integer> itemTypeIDs
    ) {
        this.description = description;
        ID = id;
        this.name = name;
        this.parentID = parentID;
        this.itemTypeIDs = itemTypeIDs;
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
    public String getName() {
        return name;
    }

    @Override
    public Optional<Integer> getParentID() {
        return Optional.ofNullable(parentID);
    }

    @Override
    public ImmutableList<Integer> getItemTypeIDs() {
        return itemTypeIDs;
    }
}
