package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.character.PortraitURLs;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PortraitURLsImplTest {

    @Test
    void parse() throws IOException {
        PortraitURLs urls = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/portraits.json"),
            new TypeReference<PortraitURLs>() { }
        );

        assertTrue(urls.get64x64().isPresent());
        assertTrue(urls.get128x128().isPresent());
        assertTrue(urls.get256x256().isPresent());
        assertTrue(urls.get512x512().isPresent());

        assertEquals(new URL("https://imageserver.eveonline.com/Character/95465499_128.jpg"), urls.get128x128().get());
        assertEquals(new URL("https://imageserver.eveonline.com/Character/95465499_256.jpg"), urls.get256x256().get());
        assertEquals(new URL("https://imageserver.eveonline.com/Character/95465499_512.jpg"), urls.get512x512().get());
        assertEquals(new URL("https://imageserver.eveonline.com/Character/95465499_64.jpg"), urls.get64x64().get());
    }
}