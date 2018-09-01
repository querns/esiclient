package gbsio.esiclient.client.request.fleets;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.request.specific.DeleteRequest;

import java.util.Optional;

/**
 * Deletes a wing of a fleet.
 *
 * The wing may have squads, but there may be no fleet members in any of the
 * squads in the wing.
 */
final public class DeleteWingRequest implements DeleteRequest {
    private final String accessToken;
    private final long fleetID;
    private final long wingID;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of a
     *                   fleet
     * @param fleetID the ID of said fleet
     * @param wingID the ID of the wing to delete
     */
    public DeleteWingRequest(final String accessToken, final long fleetID, final long wingID) {
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.fleetID = fleetID;
        this.wingID = wingID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/wings/%d/", fleetID, wingID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }

}
