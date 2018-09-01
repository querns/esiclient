package gbsio.esiclient.api.domain.response.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.common.CoordinatesImpl;

/**
 * Represents coordinates in space. Coordinates are given in meters and are
 * typically relative to their containing object (e.g.: a structure's coordinates
 * are relative to the solar system in which it resides.)
 */

@JsonDeserialize(as = CoordinatesImpl.class)
public interface Coordinates {
    /**
     * Get the X coordinate.
     *
     * @return the X coordinate
     */
    double getX();

    /**
     * Get the Y coordinate.
     *
     * Most objects in Eve are on the XZ plane.
     *
     * @return the Y coordinate
     */
    double getY();

    /**
     * Get the Z coordinate.
     *
     * @return the Z coordinate
     */
    double getZ();
}
