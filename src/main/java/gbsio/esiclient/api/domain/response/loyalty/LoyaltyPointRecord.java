package gbsio.esiclient.api.domain.response.loyalty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.domain.response.loyalty.LoyaltyPointRecordImpl;

/**
 * Represents a record of loyalty points (LP) earned by a character towards an
 * NPC corporation.
 */
@JsonDeserialize(as = LoyaltyPointRecordImpl.class)
public interface LoyaltyPointRecord {
    /**
     * Gets the ID of the corporation for whom the loyalty points were accrued.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    int getCorporationID();

    /**
     * Gets the amount of loyalty points earned.
     *
     * @return the amount of LP earned
     */
    int getLoyaltyPoints();
}
