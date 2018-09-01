package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Station;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about an NPC station.
 */
final public class StationRequest implements GetRequest<Station> {
    private final int stationID;

    /**
     * @param stationID the ID of the station to query
     */
    public StationRequest(final int stationID) {
        this.stationID = stationID;
    }

    @Override
    public String getURL() {
        return String.format("/v2/universe/stations/%d/", stationID);
    }

    @Override
    public TypeReference<Station> getExpectedType() {
        return new TypeReference<Station>() {
        };
    }
}
