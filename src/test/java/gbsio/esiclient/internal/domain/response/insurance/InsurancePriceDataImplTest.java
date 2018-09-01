package gbsio.esiclient.internal.domain.response.insurance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.insurance.InsurancePriceData;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InsurancePriceDataImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<InsurancePriceData> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/insurance/insurance.json"),
            new TypeReference<ImmutableList<InsurancePriceData>>() { }
        );

        assertEquals(1, list.size());
        InsurancePriceData data = list.get(0);

        assertEquals(1, data.getShipItemTypeID());
        assertEquals(1, data.getLevels().size());

        InsurancePriceData.InsuranceLevel level = data.getLevels().get(0);
        assertEquals(10.01F, level.getCost());
        assertEquals("Basic", level.getName());
        assertEquals(20.01F, level.getPayout());
    }
}