package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.CostIndexData;
import gbsio.esiclient.api.domain.response.industry.IndustryActivity;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CostIndexDataImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<CostIndexData> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/industry/costIndex.json"),
            new TypeReference<ImmutableList<CostIndexData>>() { }
        );

        assertEquals(1, list.size());
        CostIndexData data = list.get(0);

        assertEquals(30011392, data.getSolarSystemID());
        assertEquals(1, data.getCostIndexes().size());

        CostIndexData.CostIndex index = data.getCostIndexes().get(0);
        assertEquals(IndustryActivity.INVENTION, index.getActivity());
        assertEquals(0.0048F, index.getCostFactor());
    }
}