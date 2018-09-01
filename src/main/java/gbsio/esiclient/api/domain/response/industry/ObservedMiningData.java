package gbsio.esiclient.api.domain.response.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.domain.response.industry.ObservedMiningDataImpl;

import java.time.LocalDate;

/**
 * Represents data about mining performed within the purview of a
 * {@link MiningObserver}.
 */
@JsonDeserialize(as = ObservedMiningDataImpl.class)
public interface ObservedMiningData {
    /**
     * Get the ID of the character that performed the mining described by this
     * data.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     * @see CharacterInfo
     */
    int getCharacterID();

    /**
     * Get the last date that this data was updated.
     *
     * @return the last update date
     */
    LocalDate getLastUpdatedDate();

    /**
     * Get the number of units of material mined.
     *
     * @return the quantity
     */
    long getQuantity();

    /**
     * Get the ID of the corporation that the character belonged to at the time
     * of this data's recording.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    int getRecordedCorporationID();

    /**
     * Get the item type ID of the material that was mined.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();
}
