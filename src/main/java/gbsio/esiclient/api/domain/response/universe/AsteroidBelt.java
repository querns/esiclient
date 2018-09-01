package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.CelestialObject;
import gbsio.esiclient.internal.domain.response.universe.AsteroidBeltImpl;

/**
 * Represents an asteroid belt in New Eden.
 */
@JsonDeserialize(as = AsteroidBeltImpl.class)
public interface AsteroidBelt extends CelestialObject {
    /**
     * Gets the ID of the solar system where this asteroid belt is located.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see SolarSystem
     */
    int getSolarSystemID();
}
