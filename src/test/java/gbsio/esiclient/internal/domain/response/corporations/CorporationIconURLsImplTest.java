package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.corporation.CorporationIconURLs;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CorporationIconURLsImplTest {

    @Test
    void parse() throws IOException {
        CorporationIconURLs urls = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/icons.json"),
            new TypeReference<CorporationIconURLs>() { }
        );

        assertTrue(urls.getIcon64().isPresent());
        assertTrue(urls.getIcon128().isPresent());
        assertTrue(urls.getIcon256().isPresent());
        assertEquals("https://imageserver.eveonline.com/Corporation/1000010_128.png", urls.getIcon128().get().toString());
        assertEquals("https://imageserver.eveonline.com/Corporation/1000010_256.png", urls.getIcon256().get().toString());
        assertEquals("https://imageserver.eveonline.com/Corporation/1000010_64.png", urls.getIcon64().get().toString());
    }
}