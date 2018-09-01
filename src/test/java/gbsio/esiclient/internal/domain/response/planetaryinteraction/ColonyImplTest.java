package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.planetaryinteraction.*;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColonyImplTest {
    @Test
    void parse() throws IOException {
        Colony colony = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/planetaryinteraction/colony.json"),
            new TypeReference<Colony>() { }
        );

        assertEquals(1, colony.getLinks().size());
        assertEquals(4, colony.getPins().size());
        assertEquals(1, colony.getRoutes().size());

        Link link = colony.getLinks().get(0);
        Route route = colony.getRoutes().get(0);

        Pin one = colony.getPins().get(0);
        Pin two = colony.getPins().get(1);
        Pin three = colony.getPins().get(2);
        Pin four = colony.getPins().get(3);

        assertEquals(1005770359223L, link.getDestinationPinID());
        assertEquals(0, link.getUpgradeLevel());
        assertEquals(1005770359222L, link.getSourcePinID());

        assertTrue(one.getLastCycleStartDate().isPresent());
        assertEquals(ZonedDateTime.parse("2012-03-12T05:25:52Z"), one.getLastCycleStartDate().get());
        assertEquals(1.8616799813F, one.getLatLon().getLatitude());
        assertEquals(2.7095622845F, one.getLatLon().getLongitude());
        assertEquals(1005770359222L, one.getID());
        assertTrue(one.getSchematicID().isPresent());
        assertEquals((Integer)122, one.getSchematicID().get());
        assertEquals(2471, one.getItemTypeID());
        assertFalse(one.getExpiryDate().isPresent());
        assertFalse(one.getExtractorDetails().isPresent());
        assertFalse(one.getInstallDate().isPresent());
        assertEquals(0, one.getContents().size());

        assertEquals(1, two.getContents().size());
        Pin.ContainedItem item = two.getContents().get(0);
        assertEquals(2523, item.getAmount());
        assertEquals(2308, item.getItemTypeID());
        assertTrue(two.getLastCycleStartDate().isPresent());
        assertEquals(ZonedDateTime.parse("2012-03-12T05:28:00Z"), two.getLastCycleStartDate().get());
        assertEquals(1.8742300936F, two.getLatLon().getLatitude());
        assertEquals(2.7114277212F, two.getLatLon().getLongitude());
        assertEquals(1005770359225L, two.getID());
        assertTrue(two.getSchematicID().isPresent());
        assertEquals((Integer)122, two.getSchematicID().get());
        assertEquals(2471, two.getItemTypeID());
        assertFalse(two.getExpiryDate().isPresent());
        assertFalse(two.getExtractorDetails().isPresent());
        assertFalse(two.getInstallDate().isPresent());

        assertEquals(1.4993797604F, three.getLatLon().getLatitude());
        assertEquals(1.6234438987F, three.getLatLon().getLongitude());
        assertEquals(1005020617361L, three.getID());
        assertEquals(2551, three.getItemTypeID());
        assertFalse(three.getInstallDate().isPresent());
        assertFalse(three.getSchematicID().isPresent());
        assertFalse(three.getLastCycleStartDate().isPresent());
        assertFalse(three.getExpiryDate().isPresent());
        assertFalse(three.getFactorySchematicID().isPresent());
        assertFalse(three.getExtractorDetails().isPresent());
        assertEquals(0, three.getContents().size());

        assertTrue(four.getExpiryDate().isPresent());
        assertEquals(ZonedDateTime.parse("2012-03-12T05:13:00Z"), four.getExpiryDate().get());
        assertTrue(four.getExtractorDetails().isPresent());

        Extractor extractor = four.getExtractorDetails().get();
        assertTrue(extractor.getCycleTime().isPresent());
        assertEquals((Integer)900, extractor.getCycleTime().get());
        assertTrue(extractor.getHeadRadius().isPresent());
        assertEquals((Float)0.0127369417F, extractor.getHeadRadius().get());
        assertTrue(extractor.getProductItemTypeID().isPresent());
        assertEquals((Integer)2308, extractor.getProductItemTypeID().get());
        assertTrue(extractor.getQuantityPerCycle().isPresent());
        assertEquals((Integer)13663, extractor.getQuantityPerCycle().get());

        assertEquals(1, extractor.getHeads().size());
        Extractor.Head head = extractor.getHeads().get(0);
        assertEquals(0, head.getID());
        assertEquals(1.7371911413F, head.getLatLon().getLatitude());
        assertEquals(2.9114701781F, head.getLatLon().getLongitude());

        assertTrue(four.getInstallDate().isPresent());
        assertEquals(ZonedDateTime.parse("2012-03-11T05:28:00Z"), four.getInstallDate().get());
        assertTrue(four.getLastCycleStartDate().isPresent());
        assertEquals(ZonedDateTime.parse("2012-03-12T05:13:00Z"), four.getLastCycleStartDate().get());
        assertEquals(1.8376523103F, four.getLatLon().getLatitude());
        assertEquals(2.6950053258F, four.getLatLon().getLongitude());
        assertEquals(1005770359219L, four.getID());
        assertEquals(3064, four.getItemTypeID());

        assertEquals(0, four.getContents().size());
        assertFalse(four.getSchematicID().isPresent());
        assertFalse(four.getFactorySchematicID().isPresent());

        assertEquals(2389, route.getContentItemTypeID());
        assertEquals(1005770359221L, route.getDestinationPinID());
        assertEquals(20, route.getQuantity());
        assertEquals(425086531L, route.getID());
        assertEquals(1005770359231L, route.getSourcePinID());
        assertEquals(2, route.getWaypoints().size());
        assertTrue(route.getWaypoints().contains(1005770359228L));
        assertTrue(route.getWaypoints().contains(1005770359227L));
    }
}