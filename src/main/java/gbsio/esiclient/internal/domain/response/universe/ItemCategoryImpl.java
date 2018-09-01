package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.ItemCategory;

public class ItemCategoryImpl implements ItemCategory {
    private final int ID;
    private final ImmutableList<Integer> groupIDs;
    private final String name;
    private final boolean published;

    ItemCategoryImpl(
        @JsonProperty(value = "category_id", required = true)
        final int id,
        @JsonProperty(value = "groups", required = true)
        final ImmutableList<Integer> groupIDs,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "published", required = true)
        final boolean published
    ) {
        ID = id;
        this.groupIDs = MoreObjects.firstNonNull(groupIDs, ImmutableList.of());
        this.name = name;
        this.published = published;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public ImmutableList<Integer> getGroupIDs() {
        return groupIDs;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isPublished() {
        return published;
    }
}
