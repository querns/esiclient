package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.CelestialObject;
import gbsio.esiclient.internal.domain.response.universe.MoonImpl;

/**
 * Represents a moon in the universe.
 */
@JsonDeserialize(as = MoonImpl.class)
public interface Moon extends CelestialObject {
    /**
     * Gets the ID of the solar system containing this moon.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the unique ID for this moon.
     *
     * @return the moon ID
     */
    int getID();
}
