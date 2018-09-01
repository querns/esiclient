package gbsio.esiclient.internal.domain.response.loyalty;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.loyalty.LoyaltyPointRecord;

public class LoyaltyPointRecordImpl implements LoyaltyPointRecord {
    private final int corporationID;
    private final int loyaltyPoints;

    LoyaltyPointRecordImpl(
        @JsonProperty(value = "corporation_id", required = true)
        final int corporationID,
        @JsonProperty(value = "loyalty_points", required = true)
        final int loyaltyPoints
    ) {
        this.corporationID = corporationID;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public int getCorporationID() {
        return corporationID;
    }

    @Override
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}
