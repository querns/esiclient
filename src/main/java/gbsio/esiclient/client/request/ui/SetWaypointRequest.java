package gbsio.esiclient.client.request.ui;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.specific.BooleanPostRequest;
import gbsio.esiclient.client.domain.ui.Waypoint;

import java.util.Map;
import java.util.Optional;

/**
 * Sets a waypoint for a character.
 *
 * The waypoint can be a solar system ID, station ID, or structure ID.
 */
final public class SetWaypointRequest implements BooleanPostRequest {
    private final Waypoint waypoint;
    private final String accessToken;

    /**
     * @param accessToken an OAuth2 access token belonging to the character that
     *                    the window should open for
     * @param waypoint the new waypoint to set
     */
    public SetWaypointRequest(final String accessToken, final Waypoint waypoint) {
        this.waypoint = waypoint;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return "/v2/ui/autopilot/waypoint/";
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of(
            "add_to_beginning", waypoint.addToBeginning(),
            "clear_other_waypoints", waypoint.clearOtherWaypoints(),
            "destination_id", waypoint.getDestinationID()
        );
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.empty();
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
