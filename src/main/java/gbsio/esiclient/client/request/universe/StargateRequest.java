package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Stargate;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about a stargate.
 */
final public class StargateRequest implements GetRequest<Stargate> {
    private final int stargateID;

    /**
     * @param stargateID the ID of the stargate to query
     */
    public StargateRequest(final int stargateID) {
        this.stargateID = stargateID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/stargates/%d/", stargateID);
    }

    @Override
    public TypeReference<Stargate> getExpectedType() {
        return new TypeReference<Stargate>() {
        };
    }
}
