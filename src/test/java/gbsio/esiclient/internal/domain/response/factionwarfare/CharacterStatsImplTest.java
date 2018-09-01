package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.factionwarfare.CharacterStats;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CharacterStatsImplTest {
    @Test
    void parse() throws IOException {
        CharacterStats stats = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/factionwarfare/characterStats.json"),
            new TypeReference<CharacterStats>() { }
        );

        assertTrue(stats.getEnlistDate().isPresent());
        assertEquals(ZonedDateTime.parse("2017-10-17T00:00:00Z"), stats.getEnlistDate().get());
        assertTrue(stats.getFactionID().isPresent());
        assertEquals((Integer)500001, stats.getFactionID().get());

        assertFalse(stats.getCurrentRank().isPresent());
        assertFalse(stats.getHighestRank().isPresent());

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