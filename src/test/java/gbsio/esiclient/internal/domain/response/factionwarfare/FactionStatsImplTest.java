package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.FactionStats;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FactionStatsImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<FactionStats> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/factionwarfare/factionStats.json"),
            new TypeReference<ImmutableList<FactionStats>>() { }
        );

        assertEquals(1, list.size());
        FactionStats stats = list.get(0);

        assertEquals(500001, stats.getFactionID());
        assertEquals(28863, stats.getPilotCount());
        assertEquals(20, stats.getControlledSystemCount());

        final HistoricalPerformance<Integer> kills = stats.getKills();
        final HistoricalPerformance<Integer> victoryPoints = stats.getVictoryPoints();

        assertEquals((Integer)893, kills.getPreviousWeek());
        assertEquals((Integer)684350, kills.getTotal());
        assertEquals((Integer)136, kills.getPreviousDay());

        assertEquals((Integer)102640, victoryPoints.getPreviousWeek());
        assertEquals((Integer)52658260, victoryPoints.getTotal());
        assertEquals((Integer)15980, victoryPoints.getPreviousDay());
    }
}