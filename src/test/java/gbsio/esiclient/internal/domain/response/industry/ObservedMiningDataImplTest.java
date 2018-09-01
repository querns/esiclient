package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.ObservedMiningData;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObservedMiningDataImplTest {
    @Test
    void parse() throws IOException, ParseException {
        ImmutableList<ObservedMiningData> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/industry/observedMining.json"),
            new TypeReference<ImmutableList<ObservedMiningData>>() { }
        );

        assertEquals(1, list.size());
        ObservedMiningData data = list.get(0);

        assertEquals(95465499, data.getCharacterID());
        assertEquals(LocalDate.parse("2017-09-19"), data.getLastUpdatedDate());
        assertEquals(500, data.getQuantity());
        assertEquals(109299958, data.getRecordedCorporationID());
        assertEquals(1230, data.getItemTypeID());
    }
}