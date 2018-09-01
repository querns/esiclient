package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.universe.StarImpl;

/**
 * Represents a mass of incandescent gas in New Eden.
 */
@JsonDeserialize(as = StarImpl.class)
public interface Star {
    /**
     * Gets the age of the star.
     *
     * @return the age in years
     */
    long getAge();

    /**
     * Gets the luminosity of the star.
     *
     * @return the luminosity
     */
    float getLuminosity();

    /**
     * Gets the name of the star.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the radius of the star.
     *
     * @return the radius in meters
     */
    long getRadius();

    /**
     * Gets the ID of the solar system containing this star.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the containing solar system ID
     * @see SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the spectral class of this star.
     *
     * @return the spectral class
     */
    String getSpectralClass();

    /**
     * Gets the temperature of this star.
     *
     * @return the temperature
     */
    int getTemperature();

    /**
     * Gets the ID of the item type describing this star.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see ItemType
     */
    int getItemTypeID();
}
