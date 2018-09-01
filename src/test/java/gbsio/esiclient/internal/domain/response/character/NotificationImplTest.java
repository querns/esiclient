package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.Notification;
import gbsio.esiclient.api.domain.response.common.SenderType;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NotificationImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Notification> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/notification.json"),
            new TypeReference<ImmutableList<Notification>>() { }
        );

        assertEquals(1, list.size());
        Notification notification = list.get(0);

        assertTrue(notification.isRead().isPresent());
        assertTrue(notification.isRead().get());
        assertEquals(1, notification.getNotificationID());
        assertEquals(1000132, notification.getSenderID());
        assertEquals(SenderType.CORPORATION, notification.getSenderType());
        assertEquals("amount: 3731016.4000000004\\nitemID: 1024881021663\\npayout: 1\\n", notification.getText());
        assertEquals(ZonedDateTime.parse("2017-08-16T10:08:00Z"), notification.getTimestamp());
        assertEquals("InsurancePayoutMsg", notification.getType());
    }
}