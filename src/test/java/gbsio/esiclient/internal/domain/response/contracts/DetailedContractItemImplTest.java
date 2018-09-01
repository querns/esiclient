package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.DetailedContractItem;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DetailedContractItemImplTest {
    @Test
    void parse() throws IOException {
        final ImmutableList<DetailedContractItem> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/contracts/detailedContractItem.json"),
            new TypeReference<ImmutableList<DetailedContractItem>>() {
            }
        );

        assertTrue(list.size() > 0);
        final DetailedContractItem item = list.get(0);
        assertTrue(item.isIncluded());
        assertTrue(item.getItemID().isPresent());
        assertEquals(123456L, item.getItemID().get().longValue());
        assertEquals(1, item.getQuantity());
        assertEquals(123456L, item.getRecordID());
        assertEquals(587, item.getItemTypeID());
    }
}