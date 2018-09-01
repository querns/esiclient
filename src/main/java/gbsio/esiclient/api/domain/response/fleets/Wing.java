package gbsio.esiclient.api.domain.response.fleets;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.fleets.WingImpl;

/**
 * Represents a wing in a fleet.
 *
 * Wings are the top-level grouping device for fleets. One fleet contains many
 * wings, and one wing contains many squads.
 */
@JsonDeserialize(as = WingImpl.class)
public interface Wing {
    /**
     * Get the unique ID for this wing
     *
     * @return the wing ID
     */
    long getID();

    /**
     * Get the user-supplied name for this wing.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the squads contained by this wing.
     *
     * @return the squads
     */
    ImmutableList<Squad> getSquads();
}
