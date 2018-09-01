package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.CorporationStats;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;

import java.time.ZonedDateTime;
import java.util.Optional;

public class CorporationStatsImpl implements CorporationStats {
    private final Integer pilotCount;
    private final ZonedDateTime enlistDate;
    private final Integer factionID;
    private final HistoricalPerformance<Integer> killPerformance;
    private final HistoricalPerformance<Integer> victoryPointPerformance;

    CorporationStatsImpl(
        @JsonProperty("pilots")
        final Integer pilotCount,
        @JsonProperty("enlisted_on")
        final ZonedDateTime enlistDate,
        @JsonProperty("faction_id")
        final Integer factionID,
        @JsonProperty(value = "kills", required = true)
        final HistoricalPerformance<Integer> killPerformance,
        @JsonProperty(value = "victory_points", required = true)
        final HistoricalPerformance<Integer> victoryPointPerformance
    ) {
        this.pilotCount = pilotCount;
        this.enlistDate = enlistDate;
        this.factionID = factionID;
        this.killPerformance = killPerformance;
        this.victoryPointPerformance = victoryPointPerformance;
    }

    @Override
    public Optional<Integer> getPilotCount() {
        return Optional.ofNullable(pilotCount);
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
