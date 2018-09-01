package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.HistoricalOrderState;
import gbsio.esiclient.api.domain.response.market.OrderRange;
import gbsio.esiclient.api.domain.response.market.CharacterOrder;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CharacterOrderImplTest {
    @Test
    void parseCharacterOrderHistory() throws IOException {
        ImmutableList<CharacterOrder> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/market/characterOrderHistory.json"),
            new TypeReference<ImmutableList<CharacterOrder>>() { }
        );

        assertEquals(1, list.size());
        CharacterOrder order = list.get(0);

        assertEquals(30, order.getDuration());
        assertTrue(order.getEscrow().isPresent());
        assertEquals((Double)45.6D, order.getEscrow().get());
        assertTrue(order.isBuyOrder().isPresent());
        assertTrue(order.isBuyOrder().get());
        assertTrue(order.isCorporateOrder().isPresent());
        assertFalse(order.isCorporateOrder().get());
        assertEquals(ZonedDateTime.parse("2016-09-03T05:12:25Z"), order.getIssueDate());
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
    }

    @Test
    void parseCharacterOrder() throws IOException {
        ImmutableList<CharacterOrder> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/market/characterOrder.json"),
            new TypeReference<ImmutableList<CharacterOrder>>() { }
        );

        assertEquals(1, list.size());
        CharacterOrder order = list.get(0);

        assertEquals(30, order.getDuration());
        assertTrue(order.getEscrow().isPresent());
        assertEquals((Double)45.6D, order.getEscrow().get());
        assertTrue(order.isBuyOrder().isPresent());
        assertTrue(order.isBuyOrder().get());
        assertTrue(order.isCorporateOrder().isPresent());
        assertFalse(order.isCorporateOrder().get());
        assertEquals(ZonedDateTime.parse("2016-09-03T05:12:25Z"), order.getIssueDate());
        assertEquals(456L, order.getLocationID());
        assertTrue(order.getMinVolume().isPresent());
        assertEquals((Integer)1, order.getMinVolume().get());
        assertEquals(123L, order.getOrderID());
        assertEquals(33.3D, order.getPrice());
        assertEquals(OrderRange.STATION, order.getRange());
        assertTrue(order.getRegionID().isPresent());
        assertEquals((Integer)123, order.getRegionID().get());
        assertEquals(456, order.getItemTypeID());
        assertEquals(4422, order.getRemainingVolume());
        assertEquals(123456, order.getTotalVolume());

        assertFalse(order.getState().isPresent());
    }
}