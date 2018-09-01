package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.FactionStats;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;

public class FactionStatsImpl implements FactionStats {
    private final int factionID;
    private final HistoricalPerformance<Integer> kills;
    private final HistoricalPerformance<Integer> victoryPoints;
    private final int pilotCount;
    private final int controlledSystemCount;

    FactionStatsImpl(
        @JsonProperty(value = "faction_id", required = true)
        final int factionID,
        @JsonProperty(value = "kills", required = true)
        final HistoricalPerformance<Integer> kills,
        @JsonProperty(value = "victory_points", required = true)
        final HistoricalPerformance<Integer> victoryPoints,
        @JsonProperty(value = "pilots", required = true)
        final int pilotCount,
        @JsonProperty(value = "systems_controlled", required = true)
        final int controlledSystemCount
    ) {
        this.factionID = factionID;
        this.kills = kills;
        this.victoryPoints = victoryPoints;
        this.pilotCount = pilotCount;
        this.controlledSystemCount = controlledSystemCount;
    }

    @Override
    public int getFactionID() {
        return factionID;
    }

    @Override
    public HistoricalPerformance<Integer> getKills() {
        return kills;
    }

    @Override
    public HistoricalPerformance<Integer> getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public int getPilotCount() {
        return pilotCount;
    }

    @Override
    public int getControlledSystemCount() {
        return controlledSystemCount;
    }
}
