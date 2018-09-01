package gbsio.esiclient.api.domain.response.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.industry.MoonExtractionTimerImpl;

import java.time.ZonedDateTime;

/**
 * Represents a pending moon extraction's information.
 */
@JsonDeserialize(as = MoonExtractionTimerImpl.class)
public interface MoonExtractionTimer {
    /**
     * Gets the date that the chunk will arrive.
     *
     * After this date, a gunner may choose to fracture the moon chunk, making
     * it available for mining.
     *
     * @return the chunk arrival date
     */
    ZonedDateTime getChunkArrivalDate();

    /**
     * Get the date that the moon extraction was initiated.
     *
     * @return the start date
     */
    ZonedDateTime getExtractionStartDate();

    /**
     * Get the ID of the moon where the extraction is occurring.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the moon ID
     * @see gbsio.esiclient.api.domain.response.universe.Moon
     */
    int getMoonID();

    /**
     * Get the date that the chunk will be fractured if no action is take.n.
     *
     * @return the natural decay date
     */
    ZonedDateTime getNaturalDecayDate();

    /**
     * Get the ID of the structure currently performing the extraction.
     *
     * @return the structure ID
     */
    long getStructureID();
}
