package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.Facility;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FacilityImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Facility> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/industry/facility.json"),
            new TypeReference<ImmutableList<Facility>>() { }
        );

        assertEquals(1, list.size());
        Facility facility = list.get(0);

        assertEquals(60012544, facility.getID());
        assertEquals(1000126, facility.getOwnerID());
        assertEquals(10000001, facility.getRegionID());
        assertEquals(30000032, facility.getSolarSystemID());
        assertTrue(facility.getTaxRate().isPresent());
        assertEquals((Float)0.1F, facility.getTaxRate().get());
        assertEquals(2502, facility.getFacilityTypeID());
    }
}