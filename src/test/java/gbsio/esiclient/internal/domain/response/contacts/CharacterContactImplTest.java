package gbsio.esiclient.internal.domain.response.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.BaseContact;
import gbsio.esiclient.api.domain.response.contacts.CharacterContact;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterContactImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<CharacterContact> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/contacts/characterContact.json"),
            new TypeReference<ImmutableList<CharacterContact>>() { }
        );

        assertEquals(1, list.size());
        CharacterContact contact = list.get(0);

        assertTrue(contact.isBlocked().isPresent());
        assertTrue(contact.isWatched().isPresent());
        assertEquals(123, contact.getContactID());
        assertEquals(BaseContact.ContactType.CHARACTER, contact.getContactType());
        assertEquals(0, contact.getLabelIDs().size());
        assertTrue(contact.isBlocked().get());
        assertTrue(contact.isWatched().get());
        assertEquals(9.9f, contact.getStanding());

    }
}