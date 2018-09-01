package gbsio.esiclient.client.request.fleets;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.request.specific.DeleteRequest;

import java.util.Optional;

/**
 * Deletes an empty squad in a fleet.
 */
final public class DeleteSquadRequest implements DeleteRequest {
    private final String accessToken;
    private final long fleetID;
    private final long squadID;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of a
     *                    fleet
     * @param fleetID the ID of said fleet
     * @param squadID the ID of the squad to delete
     */
    public DeleteSquadRequest(final String accessToken, final long fleetID, final long squadID) {
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.fleetID = fleetID;
        this.squadID = squadID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/squads/%d/", fleetID, squadID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
