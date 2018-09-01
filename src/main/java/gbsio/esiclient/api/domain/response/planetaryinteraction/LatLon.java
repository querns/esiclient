package gbsio.esiclient.api.domain.response.planetaryinteraction;

/**
 * Represents a latitude/longitude pair ("lat/lon".)
 */
public interface LatLon {
    /**
     * Gets the latitude of this pin.
     *
     * @return the latitude
     */
    float getLatitude();

    /**
     * Gets the longitude of this pin.
     *
     * @return the longitude
     */
    float getLongitude();
}
