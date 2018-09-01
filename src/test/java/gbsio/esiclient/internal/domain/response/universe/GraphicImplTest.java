package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Graphic;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GraphicImplTest {
    @Test
    void parse() throws IOException {
        Graphic graphic = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/graphic.json"),
            new TypeReference<Graphic>() { }
        );

        assertTrue(graphic.getGraphicFile().isPresent());
        //noinspection SpellCheckingInspection
        assertEquals("res:/dx9/model/worldobject/planet/moon.red", graphic.getGraphicFile().get());
        assertEquals(10, graphic.getID());

        assertFalse(graphic.getCollisionFile().isPresent());
        assertFalse(graphic.getIconFolder().isPresent());
        assertFalse(graphic.getSofDna().isPresent());
        assertFalse(graphic.getSofFactionName().isPresent());
        assertFalse(graphic.getSofHullName().isPresent());
        assertFalse(graphic.getSofRaceName().isPresent());
    }
}