package gbsio.esiclient.client.request.fleets;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.fleets.FleetUpdate;
import gbsio.esiclient.api.request.specific.PutRequest;
import gbsio.esiclient.client.domain.fleets.FleetUpdateBuilder;

import java.util.Optional;

/**
 * Updates information about a fleet.
 */
final public class FleetUpdateRequest implements PutRequest {
    private final long fleetID;
    private final String accessToken;
    private final FleetUpdate fleetUpdate;

    /**
     * @param fleetID the ID of the fleet to be updated
     * @param accessToken an OAuth2 access token belonging to the boss of said
     *                    fleet
     * @param fleetUpdate the requested updates to the fleet
     * @see FleetUpdateBuilder
     */
    public FleetUpdateRequest(final long fleetID, final String accessToken, final FleetUpdate fleetUpdate) {
        this.fleetID = fleetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.fleetUpdate = Preconditions.checkNotNull(fleetUpdate);
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/", fleetID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(fleetUpdate);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
