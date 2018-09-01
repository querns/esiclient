package gbsio.esiclient.internal.domain.response.wallet;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.wallet.ContextType;
import gbsio.esiclient.api.domain.response.wallet.JournalEntry;
import gbsio.esiclient.api.domain.response.wallet.RefType;

import java.time.ZonedDateTime;
import java.util.Optional;

public class JournalEntryImpl implements JournalEntry {
    private final Double amount;
    private final Double balance;
    private final Long contextID;
    private final ContextType contextType;
    private final ZonedDateTime date;
    private final String description;
    private final Integer firstPartyID;
    private final long ID;
    private final String reason;
    private final RefType refType;
    private final Integer secondPartyID;
    private final Double tax;
    private final Integer taxReceiverID;

    JournalEntryImpl(
        @JsonProperty("amount")
        final Double amount,
        @JsonProperty("balance")
        final Double balance,
        @JsonProperty("context_id")
        final Long contextID,
        @JsonProperty("context_id_type")
        final ContextType contextType,
        @JsonProperty(value = "date", required = true)
        final ZonedDateTime date,
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty("first_party_id")
        final Integer firstPartyID,
        @JsonProperty(value = "id", required = true)
        final long ID,
        @JsonProperty("reason")
        final String reason,
        @JsonProperty(value = "ref_type", required = true)
        final RefType refType,
        @JsonProperty("second_party_id")
        final Integer secondPartyID,
        @JsonProperty("tax")
        final Double tax,
        @JsonProperty("tax_receiver_id")
        final Integer taxReceiverID
    ) {
        this.amount = amount;
        this.balance = balance;
        this.contextID = contextID;
        this.contextType = contextType;
        this.date = date;
        this.description = description;
        this.firstPartyID = firstPartyID;
        this.ID = ID;
        this.reason = reason;
        this.refType = refType;
        this.secondPartyID = secondPartyID;
        this.tax = tax;
        this.taxReceiverID = taxReceiverID;
    }

    @Override
    public Optional<Double> getAmount() {
        return Optional.ofNullable(amount);
    }

    @Override
    public Optional<Double> getBalance() {
        return Optional.ofNullable(balance);
    }

    @Override
    public Optional<Long> getContextID() {
        return Optional.ofNullable(contextID);
    }

    @Override
    public Optional<ContextType> getContextType() {
        return Optional.ofNullable(contextType);
    }

    @Override
    public ZonedDateTime getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Optional<Integer> getFirstPartyID() {
        return Optional.ofNullable(firstPartyID);
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public Optional<String> getReason() {
        return Optional.ofNullable(reason);
    }

    @Override
    public RefType getRefType() {
        return refType;
    }

    @Override
    public Optional<Integer> getSecondPartyID() {
        return Optional.ofNullable(secondPartyID);
    }

    @Override
    public Optional<Double> getTax() {
        return Optional.ofNullable(tax);
    }

    @Override
    public Optional<Integer> getTaxReceiverID() {
        return Optional.ofNullable(taxReceiverID);
    }
}
