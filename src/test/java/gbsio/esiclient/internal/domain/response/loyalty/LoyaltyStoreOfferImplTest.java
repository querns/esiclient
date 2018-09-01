package gbsio.esiclient.internal.domain.response.loyalty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.loyalty.LoyaltyStoreOffer;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyStoreOfferImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<LoyaltyStoreOffer> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/loyalty/offer.json"),
            new TypeReference<ImmutableList<LoyaltyStoreOffer>>() { }
        );

        assertEquals(2, list.size());
        LoyaltyStoreOffer one = list.get(0);
        LoyaltyStoreOffer two = list.get(1);

        assertTrue(one.getAnalysisKreditCost().isPresent());
        assertEquals((Integer)35000, one.getAnalysisKreditCost().get());
        assertEquals(0, one.getISKCost());
        assertEquals(100, one.getLoyaltyPointCost());
        assertEquals(1, one.getID());
        assertEquals(1, one.getQuantity());
        assertTrue(one.getRequiredItems().isEmpty());
        assertEquals(123, one.getItemTypeID());

        assertFalse(two.getAnalysisKreditCost().isPresent());
        assertEquals(1000, two.getISKCost());
        assertEquals(100, two.getLoyaltyPointCost());
        assertEquals(2, two.getID());
        assertEquals(10, two.getQuantity());
        assertEquals(1, two.getRequiredItems().size());
        assertEquals(1235, two.getItemTypeID());

        LoyaltyStoreOffer.RequiredItem item = two.getRequiredItems().get(0);
        assertEquals(10, item.getQuantity());
        assertEquals(1234, item.getItemTypeID());
    }
}