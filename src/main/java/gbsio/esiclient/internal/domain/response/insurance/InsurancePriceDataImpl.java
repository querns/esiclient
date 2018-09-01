package gbsio.esiclient.internal.domain.response.insurance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.insurance.InsurancePriceData;

public class InsurancePriceDataImpl implements InsurancePriceData {
    private final ImmutableList<InsuranceLevel> levels;
    private final int shipItemTypeID;

    InsurancePriceDataImpl(
        @JsonProperty(value = "levels", required = true)
        final ImmutableList<InsuranceLevel> levels,
        @JsonProperty(value = "type_id", required = true)
        final int shipItemTypeID
    ) {
        this.levels = MoreObjects.firstNonNull(levels, ImmutableList.of());
        this.shipItemTypeID = shipItemTypeID;
    }

    @Override
    public ImmutableList<InsuranceLevel> getLevels() {
        return levels;
    }

    @Override
    public int getShipItemTypeID() {
        return shipItemTypeID;
    }
}
