package gbsio.esiclient.client.request.loyalty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.loyalty.LoyaltyStoreOffer;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves available goods to purchase from a loyalty point store belonging to
 * an NPC corporation.
 */
final public class LoyaltyStoreOffersRequest implements GetRequest<ImmutableList<LoyaltyStoreOffer>> {
    private final int corporationID;

    /**
     * @param corporationID the ID of the NPC corporation to query
     */
    public LoyaltyStoreOffersRequest(final int corporationID) {
        this.corporationID = corporationID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/loyalty/stores/%d/offers/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<LoyaltyStoreOffer>> getExpectedType() {
        return new TypeReference<ImmutableList<LoyaltyStoreOffer>>() {
        };
    }
}
