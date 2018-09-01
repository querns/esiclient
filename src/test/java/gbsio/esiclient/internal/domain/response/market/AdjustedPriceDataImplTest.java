package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.AdjustedPriceData;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AdjustedPriceDataImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<AdjustedPriceData> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/market/adjustedPriceData.json"),
            new TypeReference<ImmutableList<AdjustedPriceData>>() { }
        );

        assertEquals(1, list.size());
        AdjustedPriceData data = list.get(0);
        assertTrue(data.getAdjustedPrice().isPresent());
        assertTrue(data.getAveragePrice().isPresent());
        assertEquals((Double)306988.09D, data.getAdjustedPrice().get());
        assertEquals((Double)306292.67D, data.getAveragePrice().get());
        assertEquals(32772, data.getItemTypeID());
    }
}