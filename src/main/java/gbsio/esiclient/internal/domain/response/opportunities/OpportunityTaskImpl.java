package gbsio.esiclient.internal.domain.response.opportunities;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.opportunities.OpportunityTask;

public class OpportunityTaskImpl implements OpportunityTask {
    private final String description;
    private final String name;
    private final String notification;
    private final int ID;

    OpportunityTaskImpl(
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "notification", required = true)
        final String notification,
        @JsonProperty(value = "task_id", required = true)
        final int id
    ) {
        this.description = description;
        this.name = name;
        this.notification = notification;
        ID = id;
    }

    @Override
    public String getDescription() {
        return description;
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
    public int getID() {
        return ID;
    }
}
