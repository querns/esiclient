package gbsio.esiclient.api.domain.response.factionwarfare;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.factionwarfare.WarOpponentImpl;

/**
 * Represents a faction's war against another faction.
 */
@JsonDeserialize(as = WarOpponentImpl.class)
public interface WarOpponent {
    /**
     * Get the ID of the faction that the describing faction is at war with.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID of the faction the war is against
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    int getAgainstFactionID();

    /**
     * Get the ID of the faction currently instigating the war.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the instigator's faction ID
     */
    int getFactionID();
}
