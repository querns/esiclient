package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Moon;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about a moon.
 */
final public class MoonRequest implements GetRequest<Moon> {
    private final int moonID;

    /**
     * @param moonID the ID of the moon to query
     */
    public MoonRequest(final int moonID) {
        this.moonID = moonID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/moons/%d/", moonID);
    }

    @Override
    public TypeReference<Moon> getExpectedType() {
        return new TypeReference<Moon>() {
        };
    }
}
