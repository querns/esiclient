package gbsio.esiclient.api.domain.response.opportunities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.opportunities.OpportunityTaskImpl;

/**
 * Represents info about an individual opportunity task.
 */
@JsonDeserialize(as = OpportunityTaskImpl.class)
public interface OpportunityTask {
    /**
     * Gets the description for this task.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the name for this task.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the notification for this task.
     *
     * @return the notification
     */
    String getNotification();

    /**
     * Gets the unique ID for this task.
     *
     * @return the ID
     */
    int getID();
}
