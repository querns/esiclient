package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.CorporationLeaderboard;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;

public class CorporationLeaderboardImpl implements CorporationLeaderboard {
    private final HistoricalPerformance<ImmutableList<? extends Entry>> kills;
    private final HistoricalPerformance<ImmutableList<? extends Entry>> victoryPoints;

    CorporationLeaderboardImpl(
        @JsonProperty("kills")
        final LeaderboardPerformance<ImmutableList<CorporationEntry>> kills,
        @JsonProperty("victory_points")
        final LeaderboardPerformance<ImmutableList<CorporationEntry>> victoryPoints
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

