package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.ContractItem;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContractItemImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<ContractItem> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/contracts/contractItems.json"),
            new TypeReference<ImmutableList<ContractItem>>() { }
        );

        assertEquals(1, list.size());
        ContractItem item = list.get(0);

        assertTrue(item.isIncluded());
        assertFalse(item.isSingleton());
        assertFalse(item.getRawQuantity().isPresent());
        assertEquals(1, item.getQuantity());
        assertEquals(123456L, item.getRecordID());
        assertEquals(587, item.getItemTypeID());
    }
}