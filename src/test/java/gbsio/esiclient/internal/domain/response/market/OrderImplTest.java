package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.Order;
import gbsio.esiclient.api.domain.response.market.OrderRange;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Order> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/market/order.json"),
            new TypeReference<ImmutableList<Order>>() { }
        );

        assertEquals(1, list.size());
        Order order = list.get(0);

        assertEquals(90, order.getDuration());
        assertTrue(order.isBuyOrder().isPresent());
        assertFalse(order.isBuyOrder().get());
        assertEquals(ZonedDateTime.parse("2016-09-03T05:12:25Z"), order.getIssueDate());
        assertEquals(1020988381992L, order.getLocationID());
        assertTrue(order.getMinVolume().isPresent());
        assertEquals((Integer)1, order.getMinVolume().get());
        assertEquals(4623824223L, order.getOrderID());
        assertEquals(9.9D, order.getPrice());
        assertEquals(OrderRange.REGION, order.getRange());
        assertEquals(34, order.getItemTypeID());
        assertEquals(1296000, order.getRemainingVolume());
        assertEquals(2000000, order.getTotalVolume());
    }
}