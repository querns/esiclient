package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CharacterInfoImplTest {
    @Test
    void parse() throws IOException {
        CharacterInfo info = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/info.json"),
            new TypeReference<CharacterInfo>() { }
        );

        assertTrue(info.getAncestryID().isPresent());
        assertEquals((Integer)19, info.getAncestryID().get());
        assertEquals(ZonedDateTime.parse("2015-03-24T11:37:00Z"), info.getBirthday());
        assertEquals(3, info.getBloodlineID());
        assertEquals(109299958, info.getCorporationID());
        assertTrue(info.getDescription().isPresent());
        assertEquals("", info.getDescription().get());
        assertEquals(CharacterInfo.Gender.MALE, info.getGender());
        assertEquals("CCP Bartender", info.getName());
        assertEquals(2, info.getRaceID());

        assertFalse(info.getAllianceID().isPresent());
        assertFalse(info.getFactionID().isPresent());
        assertFalse(info.getSecurityStatus().isPresent());
    }
}