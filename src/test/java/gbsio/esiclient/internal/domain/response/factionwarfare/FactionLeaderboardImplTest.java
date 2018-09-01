package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.FactionLeaderboard;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;
import gbsio.esiclient.api.domain.response.factionwarfare.Leaderboard;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FactionLeaderboardImplTest {
    @Test
    void parse() throws IOException {
        FactionLeaderboard leaderboard = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/factionwarfare/factionLeaderboard.json"),
            new TypeReference<FactionLeaderboard>() { }
        );

        HistoricalPerformance<ImmutableList<? extends Leaderboard.Entry>> kills = leaderboard.getKills();
        HistoricalPerformance<ImmutableList<? extends Leaderboard.Entry>> victoryPoints = leaderboard.getVictoryPoints();

        assertEquals(2, kills.getPreviousDay().size());
        assertEquals(2, kills.getTotal().size());
        assertEquals(2, kills.getPreviousWeek().size());

        assertEquals(2, victoryPoints.getPreviousDay().size());
        assertEquals(2, victoryPoints.getTotal().size());
        assertEquals(2, victoryPoints.getPreviousWeek().size());

        Leaderboard.Entry entry = kills.getTotal().get(0);
        assertTrue(entry.getAmount().isPresent());
        assertEquals((Integer)832273, entry.getAmount().get());
        assertTrue(entry.getEntryID().isPresent());
        assertEquals((Integer)500004, entry.getEntryID().get());
    }
}