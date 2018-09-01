package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.Facility;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FacilityImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<Facility> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/facilities.json"),
            new TypeReference<ImmutableList<Facility>>() { }
        );

        assertEquals(1, list.size());
        Facility facility = list.get(0);

        assertEquals(123, facility.getID());
        assertEquals(45678, facility.getSolarSystemID());
        assertEquals(2502, facility.getTypeID());
    }
}