package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Planet;
import gbsio.esiclient.api.request.specific.GetRequest;

final public class PlanetRequest implements GetRequest<Planet> {
    private final int planetID;

    public PlanetRequest(final int planetID) {
        this.planetID = planetID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/planets/%d/", planetID);
    }

    @Override
    public TypeReference<Planet> getExpectedType() {
        return new TypeReference<Planet>() {
        };
    }
}
