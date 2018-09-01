package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.character.FatigueInformation;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FatigueInformationImplTest {

    @Test
    void parse() throws IOException {
        FatigueInformation info = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/fatigue.json"),
            new TypeReference<FatigueInformation>() { }
        );

        assertTrue(info.getExpiry().isPresent());
        assertTrue(info.getLastJump().isPresent());
        assertTrue(info.getLastUpdate().isPresent());
        assertEquals(ZonedDateTime.parse("2017-07-06T15:47:00Z"), info.getExpiry().get());
        assertEquals(ZonedDateTime.parse("2017-07-05T15:47:00Z"), info.getLastJump().get());
        assertEquals(ZonedDateTime.parse("2017-07-05T15:42:00Z"), info.getLastUpdate().get());

    }
}