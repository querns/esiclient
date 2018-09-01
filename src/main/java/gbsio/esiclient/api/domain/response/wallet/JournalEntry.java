package gbsio.esiclient.api.domain.response.wallet;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.wallet.JournalEntryImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents an entry in a character or corporation's wallet journal.
 */
@JsonDeserialize(as = JournalEntryImpl.class)
public interface JournalEntry {
    /**
     * Gets the amount of ISK paid or received.
     *
     * @return the amount
     */
    Optional<Double> getAmount();

    /**
     * Gets the balance of the wallet after the transaction occurs.
     *
     * @return the balance
     */
    Optional<Double> getBalance();

    /**
     * Gets the ID of the context for this journal entry.
     *
     * This must be paired with {@link #getContextType()} to be useful.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the context ID
     */
    Optional<Long> getContextID();

    /**
     * Gets the type of ID that {@link #getContextID()} is for.
     *
     * @return the context type
     */
    Optional<ContextType> getContextType();

    /**
     * Gets the date of the journal entry.
     *
     * @return the date
     */
    ZonedDateTime getDate();

    /**
     * Gets the description for this journal entry.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the ID of the first party involved with this journal entry.
     *
     * This information is ambiguously defined and occasionally missing.
     * Marrying it with {@link #getDescription() the description} and {@link
     * #getRefType() the RefType} may grant more insight.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the first party ID
     */
    Optional<Integer> getFirstPartyID();

    /**
     * Gets the unique ID for this journal entry.
     *
     * @return the ID
     */
    long getID();

    /**
     * Gets the user-supplied reason for this journal entry.
     *
     * @return the reason
     */
    Optional<String> getReason();

    /**
     * Gets the reftype for this journal entry.
     *
     * @return the reftype
     */
    RefType getRefType();

    /**
     * Gets the ID of the second party involved with this journal entry.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the second party ID
     * @see #getFirstPartyID()
     */
    Optional<Integer> getSecondPartyID();

    /**
     * Gets the amount of tax revenue received from this transaction.
     *
     * @return the tax amount
     */
    Optional<Double> getTax();

    /**
     * Gets the ID of the corporation towards which taxes were paid.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the tax receiver's corporation ID
     * @see gbsio.esiclient.api.domain.response.corporation.CorporationInfo
     */
    Optional<Integer> getTaxReceiverID();
}
