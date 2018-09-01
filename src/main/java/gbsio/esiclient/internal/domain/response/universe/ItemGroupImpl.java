package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.ItemGroup;

public class ItemGroupImpl implements ItemGroup {
    private final int categoryID;
    private final int ID;
    private final String name;
    private final boolean published;
    private final ImmutableList<Integer> itemTypeIDs;

    ItemGroupImpl(
        @JsonProperty(value = "category_id", required = true)
        final int categoryID,
        @JsonProperty(value = "group_id", required = true)
        final int id,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "published", required = true)
        final boolean published,
        @JsonProperty(value = "types", required = true)
        final ImmutableList<Integer> itemTypeIDs
    ) {
        this.categoryID = categoryID;
        ID = id;
        this.name = name;
        this.published = published;
        this.itemTypeIDs = MoreObjects.firstNonNull(itemTypeIDs, ImmutableList.of());
    }

    @Override
    public int getCategoryID() {
        return categoryID;
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
    public boolean isPublished() {
        return published;
    }

    @Override
    public ImmutableList<Integer> getItemTypeIDs() {
        return itemTypeIDs;
    }
}
