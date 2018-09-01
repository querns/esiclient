package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Star;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about a star in a solar system.
 */
final public class StarRequest implements GetRequest<Star> {
    private final int starID;

    /**
     * @param starID the ID of the star to query
     */
    public StarRequest(final int starID) {
        this.starID = starID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/stars/%d/", starID);
    }

    @Override
    public TypeReference<Star> getExpectedType() {
        return new TypeReference<Star>() {
        };
    }
}
