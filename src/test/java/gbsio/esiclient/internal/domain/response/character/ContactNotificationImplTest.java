package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.ContactNotification;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ContactNotificationImplTest {
    @Test
    void testParse() throws IOException {
        ImmutableList<ContactNotification> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/contactNotification.json"),
            new TypeReference<ImmutableList<ContactNotification>>() { }
        );

        assertEquals(1, list.size());
        ContactNotification notification = list.get(0);

        assertEquals("hello friend :3", notification.getMessage());
        assertEquals(1, notification.getNotificationID());
        assertEquals(ZonedDateTime.parse("2017-08-16T10:08:00Z"), notification.getSendDate());
        assertEquals(95465499, notification.getSenderCharacterID());
        assertEquals(1.5f, notification.getStandingLevel());
    }
}