package gbsio.esiclient.internal.domain.response.wallet;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.wallet.Transaction;

import java.time.ZonedDateTime;

public class TransactionImpl implements Transaction {
    private final int clientID;
    private final ZonedDateTime date;
    private final boolean buy;
    private final boolean personal;
    private final long journalRefID;
    private final long locationID;
    private final int quantity;
    private final long ID;
    private final double unitPrice;
    private final int itemTypeID;

    TransactionImpl(
        @JsonProperty(value = "client_id", required = true) final int clientID,
        @JsonProperty(value = "date", required = true) final ZonedDateTime date,
        @JsonProperty(value = "is_buy", required = true) final boolean buy,
        @JsonProperty(value = "is_personal") final boolean personal,
        @JsonProperty(value = "journal_ref_id", required = true) final long journalRefID,
        @JsonProperty(value = "location_id", required = true) final long locationID,
        @JsonProperty(value = "quantity", required = true) final int quantity,
        @JsonProperty(value = "transaction_id", required = true) final long ID,
        @JsonProperty(value = "unit_price", required = true) final double unitPrice,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID) {
        this.clientID = clientID;
        this.date = date;
        this.buy = buy;
        this.personal = personal;
        this.journalRefID = journalRefID;
        this.locationID = locationID;
        this.quantity = quantity;
        this.ID = ID;
        this.unitPrice = unitPrice;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public int getClientID() {
        return clientID;
    }

    @Override
    public ZonedDateTime getDate() {
        return date;
    }

    @Override
    public boolean isBuy() {
        return buy;
    }

    @Override
    public boolean isPersonal() {
        return personal;
    }

    @Override
    public long getJournalRefID() {
        return journalRefID;
    }

    @Override
    public long getLocationID() {
        return locationID;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }
}
