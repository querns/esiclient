package gbsio.esiclient.api.domain.response.factionwarfare;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents statistics about a character or corporation ("concern") enlisted
 * in Faction Warfare.
 */
public interface ConcernStats {
    /**
     * Gets the date that the concern is enlisted in faction warfare.
     *
     * @return the enlist date, or absent if the concern is not currently in FW
     */
    Optional<ZonedDateTime> getEnlistDate();

    /**
     * Gets the ID of the faction the concern is enlisted with.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID for the concern's FW enrollment, or absent if the
     * concern is not currently in FW
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    Optional<Integer> getFactionID();

    /**
     * Get data about the concern's quantity of confirmed kills while enlisted
     * in faction warfare
     *
     * @return the kill quantity data
     */
    HistoricalPerformance<Integer> getKillPerformance();

    /**
     * Get data about the concern's scored victory points in faction warfare.
     *
     * @return the victory point data
     */
    HistoricalPerformance<Integer> getVictoryPointPerformance();

}
