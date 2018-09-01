package gbsio.esiclient.internal.domain.response.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.wallet.ContextType;
import gbsio.esiclient.api.domain.response.wallet.JournalEntry;
import gbsio.esiclient.api.domain.response.wallet.RefType;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class JournalEntryImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<JournalEntry> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/wallet/journalEntry.json"),
            new TypeReference<ImmutableList<JournalEntry>>() { }
        );

        assertEquals(2, list.size());
        JournalEntry one = list.get(0);
        JournalEntry two = list.get(1);

        assertTrue(one.getAmount().isPresent());
        assertEquals((Double)(-1000D), one.getAmount().get());
        assertTrue(one.getBalance().isPresent());
        assertEquals((Double)100000D, one.getBalance().get());
        assertTrue(one.getContextID().isPresent());
        assertEquals((Long)2112625428L, one.getContextID().get());
        assertTrue(one.getContextType().isPresent());
        assertEquals(ContextType.CHARACTER_ID, one.getContextType().get());
        assertEquals(ZonedDateTime.parse("2016-10-24T09:00:00Z"), one.getDate());
        //noinspection SpellCheckingInspection
        assertEquals("CCP Zoetrope transferred cash from C C P's corporate account to CCP SnowedIn's account", one.getDescription());
        assertTrue(one.getFirstPartyID().isPresent());
        assertEquals((Integer)109299958, one.getFirstPartyID().get());
        assertEquals(1234567890L, one.getID());
        assertEquals(RefType.CORPORATION_ACCOUNT_WITHDRAWAL, one.getRefType());
        assertTrue(one.getSecondPartyID().isPresent());
        assertEquals((Integer)95538921, one.getSecondPartyID().get());

        assertFalse(one.getReason().isPresent());
        assertFalse(one.getTax().isPresent());
        assertFalse(one.getTaxReceiverID().isPresent());

        assertTrue(two.getAmount().isPresent());
        assertEquals((Double)(-100000D), two.getAmount().get());
        assertTrue(two.getBalance().isPresent());
        assertEquals((Double)500000.4316D, two.getBalance().get());
        assertTrue(two.getContextID().isPresent());
        assertEquals((Long)4L, two.getContextID().get());
        assertTrue(two.getContextType().isPresent());
        assertEquals(ContextType.CONTRACT_ID, two.getContextType().get());
        assertEquals(ZonedDateTime.parse("2018-02-23T14:31:32Z"), two.getDate());
        assertEquals("Contract Deposit", two.getDescription());
        assertTrue(two.getFirstPartyID().isPresent());
        assertEquals((Integer)2112625428, two.getFirstPartyID().get());
        assertEquals(89L, two.getID());
        assertEquals(RefType.CONTRACT_DEPOSIT, two.getRefType());
        assertTrue(two.getSecondPartyID().isPresent());
        assertEquals((Integer)1000132, two.getSecondPartyID().get());

        assertFalse(one.getReason().isPresent());
        assertFalse(one.getTax().isPresent());
        assertFalse(one.getTaxReceiverID().isPresent());
    }
}