package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.MiningReport;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiningReportImplTest {
    private final static String DATE_FORMAT = "yyyy-MM-DD";

    @Test
    void parse() throws IOException, ParseException {
        ImmutableList<MiningReport> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/industry/miningReport.json"),
            new TypeReference<ImmutableList<MiningReport>>() { }
        );

        assertEquals(2, list.size());
        MiningReport one = list.get(0);
        MiningReport two = list.get(1);

        assertEquals(LocalDate.parse("2017-09-19"), one.getDate());
        assertEquals(7004, one.getQuantity());
        assertEquals(30003707, one.getSolarSystemID());
        assertEquals(17471, one.getMaterialItemTypeID());

        assertEquals(LocalDate.parse("2017-09-18"), two.getDate());
        assertEquals(5199, two.getQuantity());
        assertEquals(30003707, two.getSolarSystemID());
        assertEquals(17471, two.getMaterialItemTypeID());
    }
}