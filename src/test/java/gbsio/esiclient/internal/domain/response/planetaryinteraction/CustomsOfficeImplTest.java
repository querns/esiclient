package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.CustomsOffice;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CustomsOfficeImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<CustomsOffice> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/planetaryinteraction/customsOffice.json"),
            new TypeReference<ImmutableList<CustomsOffice>>() { }
        );

        assertEquals(1, list.size());
        CustomsOffice office = list.get(0);

        assertTrue(office.getAllianceTaxRate().isPresent());
        assertTrue(office.getExcellentStandingsTaxRate().isPresent());
        assertTrue(office.getGoodStandingsTaxRate().isPresent());
        assertTrue(office.getNeutralStandingsTaxRate().isPresent());
        assertTrue(office.getCorporationTaxRate().isPresent());
        assertFalse(office.getBadStandingsTaxRate().isPresent());
        assertFalse(office.getTerribleStandingsTaxRate().isPresent());

        assertEquals((Float)0.1F, office.getAllianceTaxRate().get());
        assertTrue(office.allowStandingsAccess());
        assertFalse(office.allowAllianceAccess());
        assertEquals((Float)0.02F, office.getCorporationTaxRate().get());
        assertEquals((Float)0.05F, office.getExcellentStandingsTaxRate().get());
        assertEquals((Float)0.2F, office.getGoodStandingsTaxRate().get());
        assertEquals((Float)0.5F, office.getNeutralStandingsTaxRate().get());
        assertEquals(1000000014530L, office.getID());
        assertEquals(1, office.getReinforceExitEnd());
        assertEquals(23, office.getReinforceExitStart());
        assertEquals(CustomsOffice.AllowedStandingLevel.NEUTRAL, office.getAllowedStandingLevel());
        assertEquals(30003657, office.getSolarSystemID());
    }
}