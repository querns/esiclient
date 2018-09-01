package gbsio.esiclient.internal.domain.response.opportunities;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.opportunities.CompletionData;

import java.time.ZonedDateTime;

public class CompletionDataImpl implements CompletionData {
    private final ZonedDateTime completedDate;
    private final int taskID;

    CompletionDataImpl(
        @JsonProperty(value = "completed_at", required = true)
        final ZonedDateTime completedDate,
        @JsonProperty(value = "task_id", required = true)
        final int taskID
    ) {
        this.completedDate = completedDate;
        this.taskID = taskID;
    }

    @Override
    public ZonedDateTime getCompletedDate() {
        return completedDate;
    }

    @Override
    public int getTaskID() {
        return taskID;
    }
}
