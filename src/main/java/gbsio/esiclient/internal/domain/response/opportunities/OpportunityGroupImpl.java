package gbsio.esiclient.internal.domain.response.opportunities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.opportunities.OpportunityGroup;

public class OpportunityGroupImpl implements OpportunityGroup {
    private final ImmutableList<Integer> connectedGroupIDs;
    private final String description;
    private final int ID;
    private final String name;
    private final String notification;
    private final ImmutableList<Integer> requiredTaskIDs;

    OpportunityGroupImpl(
        @JsonProperty(value = "connected_groups", required = true)
        final ImmutableList<Integer> connectedGroupIDs,
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty(value = "group_id", required = true)
        final int id,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "notification", required = true)
        final String notification,
        @JsonProperty(value = "required_tasks", required = true)
        final ImmutableList<Integer> requiredTaskIDs
    ) {
        this.connectedGroupIDs = MoreObjects.firstNonNull(connectedGroupIDs, ImmutableList.of());
        this.description = description;
        ID = id;
        this.name = name;
        this.notification = notification;
        this.requiredTaskIDs = MoreObjects.firstNonNull(requiredTaskIDs, ImmutableList.of());
    }

    @Override
    public ImmutableList<Integer> getConnectedGroupIDs() {
        return connectedGroupIDs;
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
    public String getNotification() {
        return notification;
    }

    @Override
    public ImmutableList<Integer> getRequiredTaskIDs() {
        return requiredTaskIDs;
    }
}
