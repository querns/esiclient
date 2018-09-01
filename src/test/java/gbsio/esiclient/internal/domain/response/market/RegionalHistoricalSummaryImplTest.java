package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.RegionalHistoricalSummary;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegionalHistoricalSummaryImplTest {
    @Test
    void parse() throws IOException, ParseException {
        ImmutableList<RegionalHistoricalSummary> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/market/regionalHistory.json"),
            new TypeReference<ImmutableList<RegionalHistoricalSummary>>() { }
        );

        assertEquals(1, list.size());
        RegionalHistoricalSummary summary = list.get(0);
        assertEquals(5.25D, summary.getAverage());
        assertEquals(LocalDate.parse("2015-05-01"), summary.getDate());
        assertEquals(5.27D, summary.getHighest());
        assertEquals(5.11D, summary.getLowest());
        assertEquals(2267L, summary.getOrderCount());
        assertEquals(16276782035L, summary.getVolume());
    }
}