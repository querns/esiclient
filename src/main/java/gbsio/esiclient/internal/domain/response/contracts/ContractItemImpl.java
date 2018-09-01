package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.contracts.ContractItem;

import java.util.Optional;

public class ContractItemImpl implements ContractItem {
    private final boolean included;
    private final boolean singleton;
    private final int quantity;
    private final long recordID;
    private final int typeID;
    private final Integer rawQuantity;

    ContractItemImpl(
        @JsonProperty(value = "is_included", required = true)
        final boolean included,
        @JsonProperty(value = "is_singleton", required = true)
        final boolean singleton,
        @JsonProperty(value = "quantity", required = true)
        final int quantity,
        @JsonProperty(value = "record_id", required = true)
        final long recordID,
        @JsonProperty(value = "type_id", required = true)
        final int typeID,
        @JsonProperty("raw_quantity")
        final Integer rawQuantity
    ) {
        this.included = included;
        this.singleton = singleton;
        this.quantity = quantity;
        this.recordID = recordID;
        this.typeID = typeID;
        this.rawQuantity = rawQuantity;
    }

    @Override
    public boolean isIncluded() {
        return included;
    }

    @Override
    public boolean isSingleton() {
        return singleton;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public long getRecordID() {
        return recordID;
    }

    @Override
    public int getItemTypeID() {
        return typeID;
    }

    @Override
    public Optional<Integer> getRawQuantity() {
        return Optional.ofNullable(rawQuantity);
    }
}
