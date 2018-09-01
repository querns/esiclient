package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Title;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TitleImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<Title> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/common/titles.json"),
            new TypeReference<ImmutableList<Title>>() { }
        );

        assertEquals(1, list.size());
        Title title = list.get(0);

        assertTrue(title.getID().isPresent());
        assertTrue(title.getName().isPresent());
        assertEquals((Integer)1, title.getID().get());
        assertEquals("Awesome Title", title.getName().get());
    }
}