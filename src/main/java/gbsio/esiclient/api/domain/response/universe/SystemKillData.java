package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.universe.SystemKillDataImpl;

/**
 * Represents data about kills performed in a solar system within the last hour.
 */
@JsonDeserialize(as = SystemKillDataImpl.class)
public interface SystemKillData {
    /**
     * Gets the number of NPC ships ("rats") killed in the last hour.
     *
     * @return the NPC kill count
     */
    int getNPCKills();

    /**
     * Gets the number of pods killed in the last hour.
     *
     * @return the pod kill count
     */
    int getPodKills();

    /**
     * Gets the number of player-owned ships killed in the last hour.
     *
     * @return the ship kill count
     */
    int getShipKills();

    /**
     * Gets the ID of the solar system where this data was accrued.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see SolarSystem
     */
    int getSolarSystemID();
}
