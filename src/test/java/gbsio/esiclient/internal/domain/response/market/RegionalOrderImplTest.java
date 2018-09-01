package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.OrderRange;
import gbsio.esiclient.api.domain.response.market.RegionalOrder;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RegionalOrderImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<RegionalOrder> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/market/regionalOrder.json"),
            new TypeReference<ImmutableList<RegionalOrder>>() { }
        );

        assertEquals(1, list.size());
        RegionalOrder order = list.get(0);

        assertEquals(90, order.getDuration());
        assertTrue(order.isBuyOrder().isPresent());
        assertFalse(order.isBuyOrder().get());
        assertEquals(ZonedDateTime.parse("2016-09-03T05:12:25Z"), order.getIssueDate());
        assertEquals(60005599L, order.getLocationID());
        assertTrue(order.getMinVolume().isPresent());
        assertEquals((Integer)1, order.getMinVolume().get());
        assertEquals(4623824223L, order.getOrderID());
        assertEquals(9.9D, order.getPrice());
        assertEquals(OrderRange.REGION, order.getRange());
        assertEquals(30000053, order.getSolarSystemID());
        assertEquals(34, order.getItemTypeID());
        assertEquals(1296000, order.getRemainingVolume());
        assertEquals(2000000, order.getTotalVolume());
    }
}