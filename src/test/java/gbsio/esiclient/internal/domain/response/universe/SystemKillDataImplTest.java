package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.SystemKillData;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SystemKillDataImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<SystemKillData> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/killData.json"),
            new TypeReference<ImmutableList<SystemKillData>>() { }
        );

        assertEquals(1, list.size());
        SystemKillData data = list.get(0);

        assertEquals(0, data.getNPCKills());
        assertEquals(24, data.getPodKills());
        assertEquals(42, data.getShipKills());
        assertEquals(30002410, data.getSolarSystemID());
    }
}