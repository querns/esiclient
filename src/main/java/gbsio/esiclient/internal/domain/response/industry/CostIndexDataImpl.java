package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.CostIndexData;

public class CostIndexDataImpl implements CostIndexData {
    private final ImmutableList<CostIndex> costIndices;
    private final int solarSystemID;

    CostIndexDataImpl(
        @JsonProperty(value = "cost_indices", required = true)
        final ImmutableList<CostIndex> costIndices,
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID
    ) {
        this.costIndices = MoreObjects.firstNonNull(costIndices, ImmutableList.of());
        this.solarSystemID = solarSystemID;
    }

    public ImmutableList<CostIndex> getCostIndexes() {
        return costIndices;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }
}
