package gbsio.esiclient.api.domain.response.loyalty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.loyalty.LoyaltyStoreOfferImpl;
import gbsio.esiclient.internal.domain.response.loyalty.RequiredItemImpl;

import java.util.Optional;

/**
 * Represents an offer at a loyalty point store.
 */
@SuppressWarnings("SpellCheckingInspection")
@JsonDeserialize(as = LoyaltyStoreOfferImpl.class)
public interface LoyaltyStoreOffer {
    /**
     * Gets the amount of Analysis Kredits (AK) needed for this offer.
     *
     * @return the AK cost, if any
     */
    Optional<Integer> getAnalysisKreditCost();

    /**
     * Gets the amount of Interstellar Kredits (ISK) needed for this offer.
     *
     * @return the ISK cost
     */
    long getISKCost();

    /**
     * Gets the amount of Loyalty Points needed for this offer.
     *
     * @return the loyalty point cost
     */
    int getLoyaltyPointCost();

    /**
     * Gets the unique ID for this offer.
     *
     * @return the offer ID
     */
    int getID();

    /**
     * Gets the amount of the item that is sold by this offer.
     *
     * @return the quantity
     */
    int getQuantity();

    /**
     * Gets the items required by this offer.
     *
     * @return 0 or more required items
     */
    ImmutableList<RequiredItem> getRequiredItems();

    /**
     * Gets the item type ID of the item that is sold by this offer.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();

    /**
     * Represents an item that is part of the cost of an LP store offer.
     */
    @JsonDeserialize(as = RequiredItemImpl.class)
    interface RequiredItem {
        /**
         * Gets the number of items of this type that are required.
         *
         * @return the quantity
         */
        int getQuantity();

        /**
         * Gets the item type ID of the item required for this offer.
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return the item type ID
         * @see gbsio.esiclient.api.domain.response.universe.ItemType
         */
        int getItemTypeID();
    }
}
