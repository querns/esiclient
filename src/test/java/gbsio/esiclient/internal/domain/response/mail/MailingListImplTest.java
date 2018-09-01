package gbsio.esiclient.internal.domain.response.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.mail.MailingList;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MailingListImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<MailingList> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/mail/mailingList.json"),
            new TypeReference<ImmutableList<MailingList>>() { }
        );

        assertEquals(1, list.size());
        MailingList mailingList = list.get(0);

        assertEquals(1, mailingList.getID());
        assertEquals("test_mailing_list", mailingList.getName());
    }
}