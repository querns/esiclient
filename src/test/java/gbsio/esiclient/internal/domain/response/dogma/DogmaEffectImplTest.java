package gbsio.esiclient.internal.domain.response.dogma;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.dogma.DogmaEffect;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DogmaEffectImplTest {
    @Test
    void parse() throws IOException {
        DogmaEffect effect = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/dogma/dogmaEffect.json"),
            new TypeReference<DogmaEffect>() { }
        );

        assertTrue(effect.getDescription().isPresent());
        assertTrue(effect.getDisplayName().isPresent());
        assertTrue(effect.getEffectCategoryID().isPresent());
        assertTrue(effect.getName().isPresent());
        assertTrue(effect.getPostExpression().isPresent());
        assertTrue(effect.getPreExpression().isPresent());
        assertEquals(6010, effect.getID());
        assertTrue(effect.getIconID().isPresent());
        assertEquals((Integer)0, effect.getIconID().get());
        assertEquals("shipModeMaxTargetRangePostDiv", effect.getName().get());
        assertEquals((Integer)2693, effect.getPostExpression().get());
        assertEquals("", effect.getDisplayName().get());
        assertEquals("", effect.getDescription().get());

        assertEquals(1, effect.getModifiers().size());
        DogmaEffect.Modifier modifier = effect.getModifiers().get(0);
        assertTrue(modifier.getDomain().isPresent());
        assertTrue(modifier.getModifiedAttributeID().isPresent());
        assertTrue(modifier.getModifyingAttributeID().isPresent());
        assertTrue(modifier.getOperator().isPresent());
        assertEquals("shipID", modifier.getDomain().get());
        assertEquals("ItemModifier", modifier.getFunc());
        assertEquals((Integer)76, modifier.getModifiedAttributeID().get());
        assertEquals((Integer)1991, modifier.getModifyingAttributeID().get());
        assertEquals((Integer)5, modifier.getOperator().get());

        assertFalse(effect.isAutoRepeatDisabled().isPresent());
        assertFalse(effect.getDischargeAttributeID().isPresent());
        assertFalse(effect.getDurationAttributeID().isPresent());
        assertFalse(effect.isElectronicChance().isPresent());
        assertFalse(effect.isAssistance().isPresent());
        assertFalse(effect.isOffensive().isPresent());
        assertFalse(effect.isWarpSafe().isPresent());
        assertFalse(effect.getRangeAttributeID().isPresent());
        assertFalse(effect.isRangeChance().isPresent());
        assertFalse(effect.getTrackingSpeedAttributeID().isPresent());
    }
}