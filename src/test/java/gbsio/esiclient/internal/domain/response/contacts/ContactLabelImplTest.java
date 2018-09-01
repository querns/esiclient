package gbsio.esiclient.internal.domain.response.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.ContactLabel;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContactLabelImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<ContactLabel> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/contacts/contactLabels.json"),
            new TypeReference<ImmutableList<ContactLabel>>() { }
        );

        assertEquals(1, list.size());
        ContactLabel label = list.get(0);

        assertEquals(1L, label.getID());
        assertEquals("Alliance Friends", label.getName());

    }
}