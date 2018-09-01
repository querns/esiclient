package gbsio.esiclient.internal.domain.response.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.wallet.Transaction;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Transaction> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/wallet/transaction.json"),
            new TypeReference<ImmutableList<Transaction>>() { }
        );

        assertEquals(1, list.size());
        Transaction transaction = list.get(0);

        assertEquals(54321, transaction.getClientID());
        assertEquals(ZonedDateTime.parse("2016-10-24T09:00:00Z"), transaction.getDate());
        assertTrue(transaction.isBuy());
        assertTrue(transaction.isPersonal());
        assertEquals(67890, transaction.getJournalRefID());
        assertEquals(60014719L, transaction.getLocationID());
        assertEquals(1, transaction.getQuantity());
        assertEquals(1234567890L, transaction.getID());
        assertEquals(587, transaction.getItemTypeID());
        assertEquals(1, transaction.getUnitPrice());
    }
}