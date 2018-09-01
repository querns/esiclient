package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.CelestialObject;
import gbsio.esiclient.internal.domain.response.universe.PlanetDataImpl;
import gbsio.esiclient.internal.domain.response.universe.SolarSystemImpl;

import java.util.Optional;

/**
 * Represents a solar system in New Eden.
 */
@JsonDeserialize(as = SolarSystemImpl.class)
public interface SolarSystem extends CelestialObject {
    /**
     * Gets the ID of the constellation containing this solar system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the constellation ID
     * @see Constellation
     */
    int getConstellationID();

    /**
     * Gets the planets contained in the solar system.
     *
     * @return 1 or more planets
     */
    ImmutableList<PlanetData> getPlanets();

    /**
     * Gets the security class of the solar system.
     *
     * @return the security class
     */
    Optional<String> getSecurityClass();

    /**
     * Gets the security status of the system.
     *
     * @return a security status between -1.0 and 1.0
     */
    float getSecurityStatus();

    /**
     * Gets the ID of the star in the solar system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the star ID
     * @see Star
     */
    Optional<Integer> getStarID();

    /**
     * Gets the IDs of stargates present in the solar system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more stargate IDs
     * @see Stargate
     */
    ImmutableList<Integer> getStargateIDs();

    /**
     * Gets the IDs of stations present in the solar system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more station IDs
     */
    ImmutableList<Integer> getStationIDs();

    /**
     * Gets the unique ID for this solar system.
     *
     * @return the ID
     */
    int getID();

    /**
     * Represents information about a planet in a solar system.
     */
    @JsonDeserialize(as = PlanetDataImpl.class)
    interface PlanetData {
        /**
         * Gets the IDs of asteroid belts present in the solar system.
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return 0 or more asteroid belt IDs
         * @see AsteroidBelt
         */
        ImmutableList<Integer> getAsteroidBeltIDs();

        /**
         * Gets the IDs of moons present in the solar system.
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return 0 or more moon IDs
         * @see Moon
         */
        ImmutableList<Integer> getMoonIDs();

        /**
         * Gets the ID for the planet being described.
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return the planet ID
         * @see Planet
         */
        int getPlanetID();
    }
}
