package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.industry.MoonExtractionTimer;

import java.time.ZonedDateTime;

public class MoonExtractionTimerImpl implements MoonExtractionTimer {
    private final ZonedDateTime chunkArrivalDate;
    private final ZonedDateTime extractionStartDate;
    private final int moonID;
    private final ZonedDateTime naturalDecayDate;
    private final long structureID;

    MoonExtractionTimerImpl(
        @JsonProperty(value = "chunk_arrival_time", required = true)
        final ZonedDateTime chunkArrivalDate,
        @JsonProperty(value = "extraction_start_time", required = true)
        final ZonedDateTime extractionStartDate,
        @JsonProperty(value = "moon_id", required = true)
        final int moonID,
        @JsonProperty(value = "natural_decay_time", required = true)
        final ZonedDateTime naturalDecayDate,
        @JsonProperty(value = "structure_id", required = true)
        final long structureID
    ) {
        this.chunkArrivalDate = chunkArrivalDate;
        this.extractionStartDate = extractionStartDate;
        this.moonID = moonID;
        this.naturalDecayDate = naturalDecayDate;
        this.structureID = structureID;
    }

    @Override
    public ZonedDateTime getChunkArrivalDate() {
        return chunkArrivalDate;
    }

    @Override
    public ZonedDateTime getExtractionStartDate() {
        return extractionStartDate;
    }

    @Override
    public int getMoonID() {
        return moonID;
    }

    @Override
    public ZonedDateTime getNaturalDecayDate() {
        return naturalDecayDate;
    }

    @Override
    public long getStructureID() {
        return structureID;
    }
}
