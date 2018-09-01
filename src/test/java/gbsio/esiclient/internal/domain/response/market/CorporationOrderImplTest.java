package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.CorporationOrder;
import gbsio.esiclient.api.domain.response.market.HistoricalOrderState;
import gbsio.esiclient.api.domain.response.market.OrderRange;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CorporationOrderImplTest {
    @Test
    void parseOrderHistory() throws IOException {
        ImmutableList<CorporationOrder> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/market/corporationOrderHistory.json"),
            new TypeReference<ImmutableList<CorporationOrder>>() { }
        );

        assertEquals(1, list.size());
        CorporationOrder order = list.get(0);

        assertEquals(30, order.getDuration());
        assertTrue(order.getEscrow().isPresent());
        assertEquals((Double)45.6D, order.getEscrow().get());
        assertTrue(order.isBuyOrder().isPresent());
        assertTrue(order.isBuyOrder().get());
        assertEquals(ZonedDateTime.parse("2016-09-03T05:12:25Z"), order.getIssueDate());
        assertTrue(order.getIssuerCharacterID().isPresent());
        assertEquals((Integer)2112625428, order.getIssuerCharacterID().get());
        assertEquals(456L, order.getLocationID());
        assertTrue(order.getMinVolume().isPresent());
        assertEquals((Integer)1, order.getMinVolume().get());
        assertEquals(123, order.getOrderID());
        assertEquals(33.3D, order.getPrice());
        assertEquals(OrderRange.STATION, order.getRange());
        assertTrue(order.getRegionID().isPresent());
        assertEquals((Integer)123, order.getRegionID().get());
        assertTrue(order.getState().isPresent());
        assertEquals(HistoricalOrderState.EXPIRED, order.getState().get());
        assertEquals(456, order.getItemTypeID());
        assertEquals(4422, order.getRemainingVolume());
        assertEquals(123456, order.getTotalVolume());
        assertEquals(1, order.getWalletDivision());
    }

    @Test
    void parseOrder() throws IOException {
        ImmutableList<CorporationOrder> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/market/corporationOrder.json"),
            new TypeReference<ImmutableList<CorporationOrder>>() { }
        );

        assertEquals(1, list.size());
        CorporationOrder order = list.get(0);

        assertEquals(30, order.getDuration());
        assertTrue(order.getEscrow().isPresent());
        assertEquals((Double)45.6D, order.getEscrow().get());
        assertTrue(order.isBuyOrder().isPresent());
        assertTrue(order.isBuyOrder().get());
        assertEquals(ZonedDateTime.parse("2016-09-03T05:12:25Z"), order.getIssueDate());
        assertTrue(order.getIssuerCharacterID().isPresent());
        assertEquals((Integer)2112625428, order.getIssuerCharacterID().get());
        assertEquals(456L, order.getLocationID());
        assertTrue(order.getMinVolume().isPresent());
        assertEquals((Integer)1, order.getMinVolume().get());
        assertEquals(123, order.getOrderID());
        assertEquals(33.3D, order.getPrice());
        assertEquals(OrderRange.STATION, order.getRange());
        assertTrue(order.getRegionID().isPresent());
        assertEquals((Integer)123, order.getRegionID().get());
        assertFalse(order.getState().isPresent());
        assertEquals(456, order.getItemTypeID());
        assertEquals(4422, order.getRemainingVolume());
        assertEquals(123456, order.getTotalVolume());
        assertEquals(1, order.getWalletDivision());
    }
}