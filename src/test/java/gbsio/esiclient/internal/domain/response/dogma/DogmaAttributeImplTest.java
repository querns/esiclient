package gbsio.esiclient.internal.domain.response.dogma;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.dogma.DogmaAttribute;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DogmaAttributeImplTest {
    @Test
    void parse() throws IOException {
        DogmaAttribute attribute = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/dogma/dogmaAttribute.json"),
            new TypeReference<DogmaAttribute>() { }
        );

        assertEquals(20, attribute.getID());

        assertTrue(attribute.getDefaultValue().isPresent());
        assertTrue(attribute.getDescription().isPresent());
        assertTrue(attribute.getName().isPresent());
        assertTrue(attribute.getDisplayName().isPresent());
        assertTrue(attribute.isHighGood().isPresent());
        assertTrue(attribute.isPublished().isPresent());
        assertTrue(attribute.getIconID().isPresent());
        assertTrue(attribute.getUnitID().isPresent());
        assertFalse(attribute.isStackable().isPresent());

        assertEquals((Float)1f, attribute.getDefaultValue().get());
        //noinspection SpellCheckingInspection
        assertEquals("Factor by which topspeed increases.", attribute.getDescription().get());
        assertEquals("Maximum Velocity Bonus", attribute.getDisplayName().get());
        assertTrue(attribute.isHighGood().get());
        assertEquals((Integer)1389, attribute.getIconID().get());
        assertEquals("speedFactor", attribute.getName().get());
        assertTrue(attribute.isPublished().get());
        assertEquals((Integer)124, attribute.getUnitID().get());
    }
}