package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.industry.ObservedMiningData;

import java.time.LocalDate;

public class ObservedMiningDataImpl implements ObservedMiningData {
    private final int characterID;
    private final LocalDate lastUpdatedDate;
    private final long quantity;
    private final int recordedCorporationID;
    private final int itemTypeID;

    ObservedMiningDataImpl(
        @JsonProperty(value = "character_id", required = true)
        final int characterID,
        @JsonProperty(value = "last_updated", required = true)
        final LocalDate lastUpdatedDate,
        @JsonProperty(value = "quantity", required = true)
        final long quantity,
        @JsonProperty(value = "recorded_corporation_id", required = true)
        final int recordedCorporationID,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID
    ) {
        this.characterID = characterID;
        this.lastUpdatedDate = lastUpdatedDate;
        this.quantity = quantity;
        this.recordedCorporationID = recordedCorporationID;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public int getCharacterID() {
        return characterID;
    }

    @Override
    public LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @Override
    public long getQuantity() {
        return quantity;
    }

    @Override
    public int getRecordedCorporationID() {
        return recordedCorporationID;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }
}
