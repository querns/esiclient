package gbsio.esiclient.internal.domain.response.loyalty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.loyalty.LoyaltyPointRecord;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyPointRecordImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<LoyaltyPointRecord> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/loyalty/loyaltyPoints.json"),
            new TypeReference<ImmutableList<LoyaltyPointRecord>>() { }
        );

        assertEquals(1, list.size());
        LoyaltyPointRecord record = list.get(0);

        assertEquals(123, record.getCorporationID());
        assertEquals(100, record.getLoyaltyPoints());
    }
}