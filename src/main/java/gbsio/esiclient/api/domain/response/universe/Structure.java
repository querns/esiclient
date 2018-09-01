package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.internal.domain.response.universe.StructureImpl;

import java.util.Optional;

/**
 * Represents a structure deployed by a player in New Eden.
 */
@JsonDeserialize(as = StructureImpl.class)
public interface Structure {
    /**
     * Gets the ID of the solar system containing this structure.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the containing solar system ID
     * @see SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the ID of the item type describing this structure.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see ItemType
     */
    Optional<Integer> getItemTypeID();

    /**
     * Gets the ID of the corporation that owns the structure.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporationID
     * @see gbsio.esiclient.api.domain.response.corporation.CorporationInfo
     */
    int getOwnerCorporationID();

    /**
     * Gets the name of this object.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the position of this object relative to its containing object.
     *
     * @return the position
     */
    Optional<Coordinates> getPosition();
}
