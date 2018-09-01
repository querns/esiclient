package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.FactionLeaderboard;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;

public class FactionLeaderboardImpl implements FactionLeaderboard {
    private final HistoricalPerformance<ImmutableList<? extends Entry>> kills;
    private final HistoricalPerformance<ImmutableList<? extends Entry>> victoryPoints;

    FactionLeaderboardImpl(
        @JsonProperty("kills")
        final LeaderboardPerformance<ImmutableList<FactionEntry>> kills,
        @JsonProperty("victory_points")
        final LeaderboardPerformance<ImmutableList<FactionEntry>> victoryPoints
    ) {
        this.kills = new HistoricalPerformanceImpl<>(kills);
        this.victoryPoints = new HistoricalPerformanceImpl<>(victoryPoints);
    }

    @Override
    public HistoricalPerformance<ImmutableList<? extends Entry>> getKills() {
        return kills;
    }

    @Override
    public HistoricalPerformance<ImmutableList<? extends Entry>> getVictoryPoints() {
        return victoryPoints;
    }
}
