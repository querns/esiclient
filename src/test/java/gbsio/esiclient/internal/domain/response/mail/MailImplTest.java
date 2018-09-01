package gbsio.esiclient.internal.domain.response.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.mail.Mail;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MailImplTest {
    @Test
    void parse() throws IOException {
        Mail mail = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/mail/mail.json"),
            new TypeReference<Mail>() { }
        );

        assertTrue(mail.getBody().isPresent());
        assertTrue(mail.getSenderCharacterID().isPresent());
        assertTrue(mail.isRead().isPresent());
        assertTrue(mail.getSubject().isPresent());
        assertTrue(mail.getDate().isPresent());
        assertEquals(0, mail.getRecipients().size());
        assertEquals(2, mail.getLabelIDs().size());

        assertEquals("blah blah blah", mail.getBody().get());
        assertEquals((Integer)90000001, mail.getSenderCharacterID().get());
        assertTrue(mail.isRead().get());
        assertEquals("test", mail.getSubject().get());
        assertEquals(ZonedDateTime.parse("2015-09-30T16:07:00Z"), mail.getDate().get());

        assertEquals(2, mail.getLabelIDs().size());
        assertTrue(mail.getLabelIDs().contains(2));
        assertTrue(mail.getLabelIDs().contains(32));
    }
}