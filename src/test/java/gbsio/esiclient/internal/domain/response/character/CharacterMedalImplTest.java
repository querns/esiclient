package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CharacterMedal;
import gbsio.esiclient.api.domain.response.common.Medal;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CharacterMedalImplTest {
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    void parse() throws IOException {
        ImmutableList<CharacterMedal> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/characterMedal.json"),
            new TypeReference<ImmutableList<CharacterMedal>>() { }
        );

        assertEquals(1, list.size());
        CharacterMedal medal = list.get(0);

        assertEquals(98000001, medal.getCorporationID());
        assertEquals(ZonedDateTime.parse("2017-03-16T15:01:45Z"), medal.getIssueDate());
        assertEquals("For 33 corp!", medal.getDescription());
        assertEquals(2112000002, medal.getIssuerID());
        assertEquals(3, medal.getMedalID());
        assertEquals("Thanks!", medal.getReason());
        assertEquals(Medal.PrivacyStatus.PRIVATE, medal.getStatus());
        assertEquals("33 tester medal", medal.getTitle());

        assertEquals(3, medal.getGraphics().size());
        Medal.MedalGraphicLayer one = medal.getGraphics().get(0);
        Medal.MedalGraphicLayer two = medal.getGraphics().get(1);
        Medal.MedalGraphicLayer three = medal.getGraphics().get(2);

        assertTrue(one.getColor().isPresent());
        assertEquals((Integer)(-1), one.getColor().get());
        assertEquals("caldari.1_1", one.getGraphic());
        assertEquals(0, one.getLayer());
        assertEquals(1, one.getPart());

        assertTrue(two.getColor().isPresent());
        assertEquals((Integer)(-330271), two.getColor().get());
        assertEquals("caldari.1_2", two.getGraphic());
        assertEquals(1, two.getLayer());
        assertEquals(1, two.getPart());

        assertTrue(three.getColor().isPresent());
        assertEquals((Integer)(-1), three.getColor().get());
        assertEquals("compass.1_2", three.getGraphic());
        assertEquals(0, three.getLayer());
        assertEquals(2, three.getPart());
    }
}