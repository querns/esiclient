package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.industry.CostIndexData;
import gbsio.esiclient.api.domain.response.industry.IndustryActivity;

public class CostIndexImpl implements CostIndexData.CostIndex {
    private final IndustryActivity activity;
    private final float costFactor;

    CostIndexImpl(
        @JsonProperty(value = "activity", required = true)
        final IndustryActivity activity,
        @JsonProperty(value = "cost_index", required = true)
        final float costFactor
    ) {
        this.activity = activity;
        this.costFactor = costFactor;
    }

    @Override
    public IndustryActivity getActivity() {
        return activity;
    }

    @Override
    public float getCostFactor() {
        return costFactor;
    }
}
