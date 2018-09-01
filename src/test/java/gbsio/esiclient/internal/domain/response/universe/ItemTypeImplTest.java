package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaAttribute;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaEffect;
import gbsio.esiclient.api.domain.response.universe.ItemType;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemTypeImplTest {
    @Test
    void parse() throws IOException {
        ItemType type = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/itemType.json"),
            new TypeReference<ItemType>() { }
        );

        assertTrue(type.getCapacity().isPresent());
        assertEquals((Float)0F, type.getCapacity().get());
        assertEquals("Massive boost to speed for a very short time. The thrust that boosts the ship, and the corresponding maximum velocity bonus, are limited by the mass of the ship that uses this module. The sheer amount of energy needed to power this system means that it must permanently reserve a fraction of the capacitor output just to maintain the integrity of its warp containment field, and when activated it substantially increases the ship's EM footprint.\r\n\r\nPenalty: Max capacitor reduced.\r\n\r\nNote: Battleship class module.", type.getDescription());
        assertEquals(2, type.getDogmaAttributes().size());
        assertEquals(46, type.getGroupID());
        assertTrue(type.getIconID().isPresent());
        assertEquals((Integer)10149, type.getIconID().get());
        assertTrue(type.getMarketGroupID().isPresent());
        assertEquals((Integer)131, type.getMarketGroupID().get());
        assertTrue(type.getMass().isPresent());
        assertEquals((Float)0F, type.getMass().get());
        //noinspection SpellCheckingInspection
        assertEquals("500MN Microwarpdrive I", type.getName());
        assertTrue(type.getPackagedVolume().isPresent());
        assertEquals((Float)50F, type.getPackagedVolume().get());
        assertTrue(type.getPortionSize().isPresent());
        assertEquals((Integer)1, type.getPortionSize().get());
        assertTrue(type.isPublished());
        assertTrue(type.getRadius().isPresent());
        assertEquals((Float)1F, type.getRadius().get());
        assertEquals(12054, type.getID());
        assertTrue(type.getVolume().isPresent());
        assertEquals((Float)50F, type.getVolume().get());

        AssignedDogmaAttribute one = type.getDogmaAttributes().get(0);
        AssignedDogmaAttribute two = type.getDogmaAttributes().get(1);

        assertEquals(4, one.getAttributeID());
        assertEquals(0, one.getNumber());

        assertEquals(763, two.getAttributeID());
        assertEquals(1, two.getNumber());

        assertEquals(2, type.getDogmaEffects().size());
        AssignedDogmaEffect three = type.getDogmaEffects().get(0);
        AssignedDogmaEffect four = type.getDogmaEffects().get(1);

        assertEquals(13, three.getEffectID());
        assertFalse(three.isDefault());

        assertEquals(16, four.getEffectID());
        assertFalse(four.isDefault());
    }
}