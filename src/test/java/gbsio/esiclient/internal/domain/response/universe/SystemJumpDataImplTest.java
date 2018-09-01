package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.SystemJumpData;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SystemJumpDataImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<SystemJumpData> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/systemJumpData.json"),
            new TypeReference<ImmutableList<SystemJumpData>>() { }
        );

        assertEquals(1, list.size());
        SystemJumpData data = list.get(0);

        assertEquals(42, data.getJumps());
        assertEquals(30002410, data.getSolarSystemID());
    }
}