package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.ColonySummary;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ColonySummaryImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<ColonySummary> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/planetaryinteraction/colonySummary.json"),
            new TypeReference<ImmutableList<ColonySummary>>() { }
        );

        assertEquals(2, list.size());
        ColonySummary one = list.get(0);
        ColonySummary two = list.get(1);

        assertEquals(ZonedDateTime.parse("2016-11-28T16:42:51Z"), one.getLastUpdateDate());
        assertEquals(1, one.getPinCount());
        assertEquals(90000001, one.getOwnerID());
        assertEquals(40023691, one.getPlanetID());
        assertEquals(ColonySummary.PlanetType.PLASMA, one.getPlanetType());
        assertEquals(30000379, one.getSolarSystemID());
        assertEquals(0, one.getUpgradeLevel());

        assertEquals(ZonedDateTime.parse("2016-11-28T16:41:54Z"), two.getLastUpdateDate());
        assertEquals(1, two.getPinCount());
        assertEquals(90000001, two.getOwnerID());
        assertEquals(40023697, two.getPlanetID());
        assertEquals(ColonySummary.PlanetType.BARREN, two.getPlanetType());
        assertEquals(30000379, two.getSolarSystemID());
        assertEquals(0, two.getUpgradeLevel());
    }
}