package gbsio.esiclient.api.domain.response.planetaryinteraction;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.LinkImpl;

/**
 * Represents a link between two {@link Pin pins} in a Planetary Interaction
 * colony.
 */
@JsonDeserialize(as = LinkImpl.class)
public interface Link {
    /**
     * Gets the ID of the destination pin for this link.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the destination pin ID
     * @see Pin
     */
    long getDestinationPinID();

    /**
     * Gets the upgrade level of this link.
     *
     * Upgrade levels allow more products to pass through them at once.
     *
     * @return an upgrade level between 0 and 10
     */
    int getUpgradeLevel();

    /**
     * Gets the ID of the source pin for this link.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the source pin ID
     */
    long getSourcePinID();
}
