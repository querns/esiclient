package gbsio.esiclient.internal.domain.response.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.BaseContact;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContactImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<BaseContact> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/contacts/contact.json"),
            new TypeReference<ImmutableList<BaseContact>>() { }
        );

        assertEquals(1, list.size());
        BaseContact contact = list.get(0);

        assertEquals(0, contact.getLabelIDs().size());
        assertEquals(2112625428, contact.getContactID());
        assertEquals(BaseContact.ContactType.CHARACTER, contact.getContactType());
        assertEquals(9.9f, contact.getStanding());
    }
}