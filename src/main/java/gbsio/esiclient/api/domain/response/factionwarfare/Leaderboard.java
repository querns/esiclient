package gbsio.esiclient.api.domain.response.factionwarfare;

import com.google.common.collect.ImmutableList;

import java.util.Optional;

/**
 * Represents information about the performance of entities in faction warfare.
 */
public interface Leaderboard {
    /**
     * Get the amount of kills scored by the top entities of this type.
     *
     * @return the kill performance
     */
    HistoricalPerformance<ImmutableList<? extends Entry>> getKills();

    /**
     * Get the amount of victory points scored by the top entities of this type.
     *
     * @return the victory point performance
     */
    HistoricalPerformance<ImmutableList<? extends Entry>> getVictoryPoints();

    /**
     * Represents an entry in the leaderboard.
     */
    interface Entry {
        /**
         * Get the amount of this statistic for this entity.
         *
         * @return the amount
         */
        Optional<Integer> getAmount();

        /**
         * Get the ID of the entity described by this entry
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return the ID of a character, corporation, or faction
         */
        Optional<Integer> getEntryID();
    }
}
