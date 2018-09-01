package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.AsteroidBelt;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about an asteroid belt in a solar system.
 */
final public class AsteroidBeltsRequest implements GetRequest<AsteroidBelt> {
    private final int asteroidBeltID;

    /**
     * @param asteroidBeltID the ID of the asteroid belt to query
     */
    public AsteroidBeltsRequest(final int asteroidBeltID) {
        this.asteroidBeltID = asteroidBeltID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/asteroid_belts/%d/", asteroidBeltID);
    }

    @Override
    public TypeReference<AsteroidBelt> getExpectedType() {
        return new TypeReference<AsteroidBelt>() {
        };
    }
}
