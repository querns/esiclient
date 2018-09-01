package gbsio.esiclient.api.domain.response.opportunities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.opportunities.OpportunityGroupImpl;

/**
 * Represents a grouping of opportunity tasks.
 */
@JsonDeserialize(as = OpportunityGroupImpl.class)
public interface OpportunityGroup {
    /**
     * Gets the IDs of groups that are connected to this group on the
     * Opportunities UI.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the connected group IDs
     */
    ImmutableList<Integer> getConnectedGroupIDs();

    /**
     * Gets the description for this group.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the unique ID for this group.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets the name for this group.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the notification for this group.
     *
     * @return the notification
     */
    String getNotification();

    /**
     * Gets the IDs of tasks needed to complete this group.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the task IDs belonging to this group
     * @see OpportunityTask
     */
    ImmutableList<Integer> getRequiredTaskIDs();
}
