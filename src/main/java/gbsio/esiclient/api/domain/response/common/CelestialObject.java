package gbsio.esiclient.api.domain.response.common;

/**
 * Represents methods shared by objects in space.
 */
public interface CelestialObject {
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
    Coordinates getPosition();
}
