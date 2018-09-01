package gbsio.esiclient.api.domain.response.wallet;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.internal.domain.response.wallet.TransactionImpl;

import java.time.ZonedDateTime;

/**
 * Represents a wallet transaction.
 */
@JsonDeserialize(as = TransactionImpl.class)
public interface Transaction {
    /**
     * Gets the ID of the character involved with this transaction.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the client's character ID
     * @see CharacterInfo
     */
    int getClientID();

    /**
     * Gets the date of the transaction.
     *
     * @return the transaction date
     */
    ZonedDateTime getDate();

    /**
     * Gets whether or not this transaction was a buy order.
     *
     * @return true if the transaction was a buy order, false if a sell order
     */
    boolean isBuy();

    /**
     * Gets whether or not this transaction was made at the personal scope.
     *
     * @return true if the transaction was made at personal scope, false if made
     * at corporation scope.
     */
    boolean isPersonal();

    /**
     * Gets the ID of the journal reference paired with this transaction.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the journal reference ID
     * @see JournalEntry
     */
    long getJournalRefID();

    /**
     * Gets the ID of the location where this transaction occurred.
     *
     * This may be a station or structure ID.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the location ID
     */
    long getLocationID();

    /**
     * Gets the quantity of goods sold or purchased with this transaction.
     *
     * @return the quantity
     */
    int getQuantity();

    /**
     * Gets the unique ID for this transaction.
     *
     * @return the ID
     */
    long getID();

    /**
     * Gets the price paid or received per unit sold.
     *
     * This may differ from the price of the order.
     *
     * @return the unit price
     */
    double getUnitPrice();

    /**
     * Gets the ID of the item type being purchased or sold in this transaction.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     */
    int getItemTypeID();
}
