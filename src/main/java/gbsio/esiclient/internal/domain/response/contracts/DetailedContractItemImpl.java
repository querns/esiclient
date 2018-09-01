package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.contracts.DetailedContractItem;

import java.util.Optional;

public class DetailedContractItemImpl implements DetailedContractItem {
    private final Integer blueprintRuns;
    private final Long itemID;
    private final int itemTypeID;
    private final Integer materialEfficiency;
    private final int quantity;
    private final long recordID;
    private final Integer timeEfficiency;
    private final Boolean blueprintCopy;
    private final boolean included;

    DetailedContractItemImpl(
        @JsonProperty("runs")
        final Integer blueprintRuns,
        @JsonProperty("item_id")
        final Long itemID,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID,
        @JsonProperty("material_efficiency")
        final Integer materialEfficiency,
        @JsonProperty(value = "quantity", required = true)
        final int quantity,
        @JsonProperty(value = "record_id", required = true)
        final long recordID,
        @JsonProperty("time_efficiency")
        final Integer timeEfficiency,
        @JsonProperty("is_blueprint_copy")
        final Boolean blueprintCopy,
        @JsonProperty(value = "is_included", required = true)
        final boolean included
    ) {
        this.blueprintRuns = blueprintRuns;
        this.itemID = itemID;
        this.itemTypeID = itemTypeID;
        this.materialEfficiency = materialEfficiency;
        this.quantity = quantity;
        this.recordID = recordID;
        this.timeEfficiency = timeEfficiency;
        this.blueprintCopy = blueprintCopy;
        this.included = included;
    }

    @Override
    public Optional<Integer> getBlueprintRuns() {
        return Optional.ofNullable(blueprintRuns);
    }

    @Override
    public Optional<Long> getItemID() {
        return Optional.ofNullable(itemID);
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }

    @Override
    public Optional<Integer> getMaterialEfficiency() {
        return Optional.ofNullable(materialEfficiency);
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
    public Optional<Integer> getTimeEfficiency() {
        return Optional.ofNullable(timeEfficiency);
    }

    public Optional<Boolean> isBlueprintCopy() {
        return Optional.ofNullable(blueprintCopy);
    }

    @Override
    public boolean isIncluded() {
        return included;
    }
}
