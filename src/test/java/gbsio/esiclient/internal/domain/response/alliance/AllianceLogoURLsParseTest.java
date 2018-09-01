package gbsio.esiclient.internal.domain.response.alliance;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.alliance.AllianceLogoURLs;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllianceLogoURLsParseTest {
    @Test
    void parse() throws IOException {
        AllianceLogoURLs logos = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/alliance/allianceLogos.json"),
            new TypeReference<AllianceLogoURLs>() { }
        );

        assertTrue(AllianceLogoURLs.class.isInstance(logos));
        assertTrue(logos.getLogo128().isPresent());
        assertTrue(logos.getLogo64().isPresent());
        assertEquals("https://imageserver.eveonline.com/Alliance/503818424_128.png", logos.getLogo128().get().toString());
        assertEquals("https://imageserver.eveonline.com/Alliance/503818424_64.png", logos.getLogo64().get().toString());
    }
}