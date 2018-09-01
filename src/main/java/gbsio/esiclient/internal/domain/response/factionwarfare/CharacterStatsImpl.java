package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.CharacterStats;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;

import java.time.ZonedDateTime;
import java.util.Optional;

public class CharacterStatsImpl implements CharacterStats {
    private final Integer currentRank;
    private final Integer highestRank;
    private final ZonedDateTime enlistDate;
    private final Integer factionID;
    private final HistoricalPerformance<Integer> killPerformance;
    private final HistoricalPerformance<Integer> victoryPointPerformance;

    CharacterStatsImpl(
        @JsonProperty("current_rank")
        final Integer currentRank,
        @JsonProperty("highest_rank")
        final Integer highestRank,
        @JsonProperty("enlisted_on")
        final ZonedDateTime enlistDate,
        @JsonProperty("faction_id")
        final Integer factionID,
        @JsonProperty("kills")
        final HistoricalPerformance<Integer> killPerformance,
        @JsonProperty("victory_points")
        final HistoricalPerformance<Integer> victoryPointPerformance
    ) {
        this.currentRank = currentRank;
        this.highestRank = highestRank;
        this.enlistDate = enlistDate;
        this.factionID = factionID;
        this.killPerformance = killPerformance;
        this.victoryPointPerformance = victoryPointPerformance;
    }

    @Override
    public Optional<Integer> getCurrentRank() {
        return Optional.ofNullable(currentRank);
    }

    @Override
    public Optional<Integer> getHighestRank() {
        return Optional.ofNullable(highestRank);
    }

    @Override
    public Optional<ZonedDateTime> getEnlistDate() {
        return Optional.ofNullable(enlistDate);
    }

    @Override
    public Optional<Integer> getFactionID() {
        return Optional.ofNullable(factionID);
    }

    @Override
    public HistoricalPerformance<Integer> getKillPerformance() {
        return killPerformance;
    }

    @Override
    public HistoricalPerformance<Integer> getVictoryPointPerformance() {
        return victoryPointPerformance;
    }
}
