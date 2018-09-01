package gbsio.esiclient.internal.domain.response.dogma;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaAttribute;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaEffect;
import gbsio.esiclient.api.domain.response.dogma.DynamicItem;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DynamicItemImplTest {
    @Test
    void parse() throws IOException {
        DynamicItem item = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/dogma/dynamicItem.json"),
            new TypeReference<DynamicItem>() { }
        );

        assertEquals(2112625428, item.getCreatorCharacterID());
        assertEquals(47845, item.getMutatorItemTypeID());
        assertEquals(33103, item.getSourceItemTypeID());

        assertEquals(1, item.getDogmaAttributes().size());
        assertEquals(1, item.getDogmaEffects().size());

        AssignedDogmaAttribute attribute = item.getDogmaAttributes().get(0);
        AssignedDogmaEffect effect = item.getDogmaEffects().get(0);

        assertEquals(9, attribute.getAttributeID());
        assertEquals(350, attribute.getNumber());
        assertEquals(508, effect.getEffectID());
        assertFalse(effect.isDefault());
    }
}