package gbsio.esiclient.api.domain.response.factionwarfare;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.factionwarfare.FactionStatsImpl;

/**
 * Represents stats about a faction in faction warfare.
 */
@JsonDeserialize(as = FactionStatsImpl.class)
public interface FactionStats {
    /**
     * Get the ID of the faction being described by this entry.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    int getFactionID();

    /**
     * Get the performance data for kills scored by this faction.
     *
     * @return the kill performance
     */
    HistoricalPerformance<Integer> getKills();

    /**
     * Get the number of pilots currently enrolled with this faction.
     *
     * @return the pilot count
     */
    int getPilotCount();

    /**
     * Get the number of systems controlled by this faction.
     *
     * @return the controlled system count
     */
    int getControlledSystemCount();

    /**
     * Get the performance data for victory points earned by this faction.
     *
     * @return the victory point performance
     */
    HistoricalPerformance<Integer> getVictoryPoints();
}
