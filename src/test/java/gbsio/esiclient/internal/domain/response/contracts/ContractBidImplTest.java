package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.ContractBid;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ContractBidImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<ContractBid> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/contracts/contractBids.json"),
            new TypeReference<ImmutableList<ContractBid>>() { }
        );

        assertEquals(1, list.size());
        ContractBid bid = list.get(0);

        assertEquals(1.23f, bid.getAmount());
        assertEquals(1, bid.getID());
        assertTrue(bid.getBidderID().isPresent());
        assertEquals(123, bid.getBidderID().get().intValue());
        assertEquals(ZonedDateTime.parse("2017-01-01T10:10:10Z"), bid.getDate());
    }
}