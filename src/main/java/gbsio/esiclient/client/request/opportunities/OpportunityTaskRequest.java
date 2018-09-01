package gbsio.esiclient.client.request.opportunities;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.opportunities.OpportunityTask;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about a single opportunity task.
 */
final public class OpportunityTaskRequest implements GetRequest<OpportunityTask> {
    private final int taskID;

    /**
     * @param taskID the ID of the task to query
     */
    public OpportunityTaskRequest(final int taskID) {
        this.taskID = taskID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/opportunities/tasks/%d/", taskID);
    }

    @Override
    public TypeReference<OpportunityTask> getExpectedType() {
        return new TypeReference<OpportunityTask>() { };
    }
}
