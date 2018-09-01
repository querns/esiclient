package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.factionwarfare.CorporationStats;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CorporationStatsImplTest {
    @Test
    void parse() throws IOException {
        CorporationStats stats = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/factionwarfare/corporationStats.json"),
            new TypeReference<CorporationStats>() { }
        );

        assertTrue(stats.getEnlistDate().isPresent());
        assertTrue(stats.getFactionID().isPresent());
        assertTrue(stats.getPilotCount().isPresent());
        assertEquals(ZonedDateTime.parse("2017-10-17T00:00:00Z"), stats.getEnlistDate().get());
        assertEquals((Integer)500001, stats.getFactionID().get());
        assertEquals((Integer)28863, stats.getPilotCount().get());

        HistoricalPerformance<Integer> kills = stats.getKillPerformance();
        HistoricalPerformance<Integer> victoryPoints = stats.getVictoryPointPerformance();

        assertEquals((Integer)893, kills.getPreviousWeek());
        assertEquals((Integer)684350, kills.getTotal());
        assertEquals((Integer)136, kills.getPreviousDay());

        assertEquals((Integer)102640, victoryPoints.getPreviousWeek());
        assertEquals((Integer)52658260, victoryPoints.getTotal());
        assertEquals((Integer)15980, victoryPoints.getPreviousDay());

    }
}