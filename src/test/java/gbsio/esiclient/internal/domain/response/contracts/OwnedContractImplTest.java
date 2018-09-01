package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.OwnedContract;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OwnedContractImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<OwnedContract> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/contracts/ownedContract.json"),
            new TypeReference<ImmutableList<OwnedContract>>() { }
        );

        assertEquals(1, list.size());
        OwnedContract contract = list.get(0);

        assertEquals(0, contract.getAcceptorID());
        assertEquals(0, contract.getAssigneeID());
        assertEquals(OwnedContract.Availability.PUBLIC, contract.getAvailability());
        assertTrue(contract.getBuyout().isPresent());
        assertEquals((Double)10000000000.01d, contract.getBuyout().get());
        assertEquals(1, contract.getContractID());
        assertTrue(contract.getDateAccepted().isPresent());
        assertEquals(ZonedDateTime.parse("2017-06-06T13:12:32Z"), contract.getDateAccepted().get());
        assertTrue(contract.getDateCompleted().isPresent());
        assertEquals(ZonedDateTime.parse("2017-06-06T13:12:32Z"), contract.getDateCompleted().get());
        assertEquals(ZonedDateTime.parse("2017-06-13T13:12:32Z"), contract.getExpirationDate());
        assertEquals(ZonedDateTime.parse("2017-06-06T13:12:32Z"), contract.getIssueDate());
        assertTrue(contract.getDaysToComplete().isPresent());
        assertEquals((Integer)0, contract.getDaysToComplete().get());
        assertTrue(contract.getEndLocationID().isPresent());
        assertEquals((Long)60014719L, contract.getEndLocationID().get());
        assertTrue(contract.isCorpContract());
        assertEquals(456, contract.getIssuerCorporationID());
        assertEquals(123, contract.getIssuerID());
        assertTrue(contract.getPrice().isPresent());
        assertEquals((Double)1000000.01d, contract.getPrice().get());
        assertTrue(contract.getReward().isPresent());
        assertEquals((Double)0.01d, contract.getReward().get());
        assertTrue(contract.getStartLocationID().isPresent());
        assertEquals((Long)60014719L, contract.getStartLocationID().get());
        assertEquals(OwnedContract.Status.OUTSTANDING, contract.getStatus());
        assertEquals(OwnedContract.Type.AUCTION, contract.getType());
        assertTrue(contract.getVolume().isPresent());
        assertEquals((Double)0.01d, contract.getVolume().get());
    }
}