package gbsio.esiclient.internal.domain.response.skills;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.skills.CharacterAttributes;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterAttributesImplTest {
    @Test
    void parse() throws IOException {
        CharacterAttributes attributes = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/skills/attributes.json"),
            new TypeReference<CharacterAttributes>() { }
        );

        assertEquals(20, attributes.getCharisma());
        assertEquals(20, attributes.getIntelligence());
        assertEquals(20, attributes.getPerception());
        assertEquals(20, attributes.getMemory());
        assertEquals(20, attributes.getWillpower());

        assertFalse(attributes.getBonusRemaps().isPresent());
        assertFalse(attributes.getLastRemapDate().isPresent());
        assertFalse(attributes.getRemapCooldownDate().isPresent());
    }
}