package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.CharacterLeaderboard;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;

public class CharacterLeaderboardImpl implements CharacterLeaderboard {
    private final HistoricalPerformance<ImmutableList<? extends Entry>> kills;
    private final HistoricalPerformance<ImmutableList<? extends Entry>> victoryPoints;

    CharacterLeaderboardImpl(
        @JsonProperty("kills")
        final LeaderboardPerformance<ImmutableList<CharacterEntry>> kills,
        @JsonProperty("victory_points")
        final LeaderboardPerformance<ImmutableList<CharacterEntry>> victoryPoints
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
