package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.universe.AncestryImpl;

import java.util.Optional;

/**
 * Represents a character or NPC's ancestry.
 */
@JsonDeserialize(as = AncestryImpl.class)
public interface Ancestry {
    /**
     * Gets the ID of the bloodline associated with this ancestry.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the bloodline ID
     * @see Bloodline
     */
    int getBloodlineID();

    /**
     * Gets the description for this ancestry.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the ID of the icon for this ancestry.
     *
     * @return the icon ID
     */
    Optional<Integer> getIconID();

    /**
     * Gets the unique ID for this ancestry.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets the name of this ancestry.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the short description for this ancestry.
     *
     * @return the short description
     */
    Optional<String> getShortDescription();
}
