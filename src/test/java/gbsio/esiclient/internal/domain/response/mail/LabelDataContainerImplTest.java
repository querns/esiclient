package gbsio.esiclient.internal.domain.response.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.common.mail.LabelColor;
import gbsio.esiclient.api.domain.response.mail.Label;
import gbsio.esiclient.api.domain.response.mail.LabelDataContainer;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabelDataContainerImplTest {
    @Test
    void parse() throws IOException {
        LabelDataContainer container = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/mail/labelDataContainer.json"),
            new TypeReference<LabelDataContainer>() { }
        );

        assertTrue(container.getTotalUnreadCount().isPresent());
        assertEquals((Integer)5, container.getTotalUnreadCount().get());

        assertEquals(2, container.getLabels().size());
        Label one = container.getLabels().get(0);
        Label two = container.getLabels().get(1);

        assertTrue(one.getColor().isPresent());
        assertTrue(one.getID().isPresent());
        assertTrue(one.getName().isPresent());
        assertTrue(one.getUnreadCount().isPresent());

        assertTrue(two.getColor().isPresent());
        assertTrue(two.getID().isPresent());
        assertTrue(two.getName().isPresent());
        assertTrue(two.getUnreadCount().isPresent());

        assertEquals(LabelColor.COLOR_660066, one.getColor().get());
        assertEquals((Integer)16, one.getID().get());
        assertEquals("PINK", one.getName().get());
        assertEquals((Integer)4, one.getUnreadCount().get());

        assertEquals(LabelColor.COLOR_FFFFFF, two.getColor().get());
        assertEquals((Integer)17, two.getID().get());
        assertEquals("WHITE", two.getName().get());
        assertEquals((Integer)1, two.getUnreadCount().get());
    }
}