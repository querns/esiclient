package gbsio.esiclient.internal.domain.response.insurance;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.insurance.InsurancePriceData;

public class InsuranceLevelImpl implements InsurancePriceData.InsuranceLevel {
    private final float cost;
    private final String name;
    private final float payout;

    InsuranceLevelImpl(
        @JsonProperty(value = "cost", required = true)
        final float cost,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "payout", required = true)
        final float payout
    ) {
        this.cost = cost;
        this.name = name;
        this.payout = payout;
    }

    @Override
    public float getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getPayout() {
        return payout;
    }
}
