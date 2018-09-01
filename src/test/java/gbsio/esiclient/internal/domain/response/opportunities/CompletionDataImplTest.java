package gbsio.esiclient.internal.domain.response.opportunities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.opportunities.CompletionData;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CompletionDataImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<CompletionData> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/opportunities/completionData.json"),
            new TypeReference<ImmutableList<CompletionData>>() { }
        );

        assertEquals(1, list.size());
        CompletionData data = list.get(0);

        assertEquals(ZonedDateTime.parse("2016-04-29T12:34:56Z"), data.getCompletedDate());
        assertEquals(1, data.getTaskID());
    }
}