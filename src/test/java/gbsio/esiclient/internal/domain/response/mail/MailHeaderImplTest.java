package gbsio.esiclient.internal.domain.response.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.mail.MailHeader;
import gbsio.esiclient.api.domain.common.mail.Recipient;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MailHeaderImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<MailHeader> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/mail/headers.json"),
            new TypeReference<ImmutableList<MailHeader>>() { }
        );

        assertEquals(1, list.size());
        MailHeader header = list.get(0);

        assertTrue(header.isRead().isPresent());
        assertTrue(header.getDate().isPresent());
        assertTrue(header.getSenderCharacterID().isPresent());
        assertTrue(header.getMailID().isPresent());
        assertTrue(header.getSubject().isPresent());
        assertTrue(header.getDate().isPresent());

        assertEquals((Integer)90000001, header.getSenderCharacterID().get());
        assertTrue(header.isRead().get());
        assertEquals((Integer)7, header.getMailID().get());
        assertEquals("Title for EVE Mail", header.getSubject().get());
        assertEquals(ZonedDateTime.parse("2015-09-30T16:07:00Z"), header.getDate().get());

        assertEquals(1, header.getLabelIDs().size());
        assertEquals(1, header.getRecipients().size());
        assertTrue(header.getLabelIDs().contains(3));

        Recipient recipient = header.getRecipients().get(0);
        assertEquals(90000002, recipient.getID());
        assertEquals(Recipient.Type.CHARACTER, recipient.getType());
    }
}