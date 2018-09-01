package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Extractor;

import java.util.Optional;

public class ExtractorImpl implements Extractor {
    private final Integer cycleTime;
    private final Float headRadius;
    private final ImmutableList<Head> heads;
    private final Integer productItemTypeID;
    private final Integer quantityPerCycle;

    ExtractorImpl(
        @JsonProperty("cycle_time")
        final Integer cycleTime,
        @JsonProperty("head_radius")
        final Float headRadius,
        @JsonProperty(value = "heads", required = true)
        final ImmutableList<Head> heads,
        @JsonProperty("product_type_id")
        final Integer productItemTypeID,
        @JsonProperty("qty_per_cycle")
        final Integer quantityPerCycle
    ) {
        this.cycleTime = cycleTime;
        this.headRadius = headRadius;
        this.heads = MoreObjects.firstNonNull(heads, ImmutableList.of());
        this.productItemTypeID = productItemTypeID;
        this.quantityPerCycle = quantityPerCycle;
    }

    @Override
    public Optional<Integer> getCycleTime() {
        return Optional.ofNullable(cycleTime);
    }

    @Override
    public Optional<Float> getHeadRadius() {
        return Optional.ofNullable(headRadius);
    }

    @Override
    public ImmutableList<Head> getHeads() {
        return heads;
    }

    @Override
    public Optional<Integer> getProductItemTypeID() {
        return Optional.ofNullable(productItemTypeID);
    }

    @Override
    public Optional<Integer> getQuantityPerCycle() {
        return Optional.ofNullable(quantityPerCycle);
    }
}
