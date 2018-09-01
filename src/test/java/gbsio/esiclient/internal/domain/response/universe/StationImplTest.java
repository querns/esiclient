package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Station;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StationImplTest {
    @Test
    void parse() throws IOException {
        Station station = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/station.json"),
            new TypeReference<Station>() { }
        );

        assertEquals(50000000, station.getMaxDockableShipVolume());
        //noinspection SpellCheckingInspection
        assertEquals("Jakanerva III - Moon 15 - Prompt Delivery Storage", station.getName());
        assertEquals(10000, station.getOfficeRentalCost());
        assertTrue(station.getOwnerCorporationID().isPresent());
        assertEquals((Integer)1000003, station.getOwnerCorporationID().get());
        assertEquals(165632286720D, station.getPosition().getX());
        assertEquals(2771804160D, station.getPosition().getY());
        assertEquals(-2455331266560D, station.getPosition().getZ());
        assertTrue(station.getRaceID().isPresent());
        assertEquals((Integer)1, station.getRaceID().get());
        assertEquals(0.5F, station.getReprocessingEfficiency());
        assertEquals(0.05F, station.getReprocessingTake());
        assertEquals(12, station.getServices().size());
        assertEquals(60000277, station.getID());
        assertEquals(30000148, station.getSolarSystemID());
        assertEquals(1531, station.getItemTypeID());

        final ImmutableList<Station.Service> services = ImmutableList.of(
            Station.Service.of("courier-missions"),
            Station.Service.of("reprocessing-plant"),
            Station.Service.of("market"),
            Station.Service.of("repair-facilities"),
            Station.Service.of("fitting"),
            Station.Service.of("news"),
            Station.Service.of("storage"),
            Station.Service.of("insurance"),
            Station.Service.of("docking"),
            Station.Service.of("office-rental"),
            Station.Service.of("loyalty-point-store"),
            Station.Service.of("navy-offices")
        );

        assertTrue(station.getServices().containsAll(services));
    }
}