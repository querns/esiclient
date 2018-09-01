package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.Contract;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ContractImplTest {
    @Test
    void parse() throws IOException {
        final ImmutableList<Contract> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/contracts/contract.json"),
            new TypeReference<ImmutableList<Contract>>() {
            }
        );

        assertEquals(1, list.size());
        final Contract contract = list.get(0);

        assertTrue(contract.getBuyout().isPresent());
        assertEquals(10000000000.01D, contract.getBuyout().get().doubleValue());
        assertEquals(1, contract.getContractID());
        assertEquals(ZonedDateTime.parse("2017-06-13T13:12:32Z"), contract.getExpirationDate());
        assertEquals(ZonedDateTime.parse("2017-06-06T13:12:32Z"), contract.getIssueDate());
        assertTrue(contract.getDaysToComplete().isPresent());
        assertEquals(0, contract.getDaysToComplete().get().intValue());
        assertTrue(contract.getEndLocationID().isPresent());
        assertEquals(60014719, contract.getEndLocationID().get().intValue());
        assertTrue(contract.isCorpContract());
        assertEquals(456, contract.getIssuerCorporationID());
        assertEquals(123, contract.getIssuerID());
        assertTrue(contract.getPrice().isPresent());
        assertEquals(1000000.01D, contract.getPrice().get().doubleValue());
        assertTrue(contract.getReward().isPresent());
        assertEquals(0.01D, contract.getReward().get().doubleValue());
        assertTrue(contract.getStartLocationID().isPresent());
        assertEquals(60014719L, contract.getStartLocationID().get().longValue());
        assertEquals(Contract.Type.AUCTION, contract.getType());
        assertTrue(contract.getVolume().isPresent());
        assertEquals(0.01D, contract.getVolume().get().doubleValue());
    }
}