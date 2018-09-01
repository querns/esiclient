package gbsio.esiclient.client.request.fleets;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.specific.PutRequest;

import java.util.Optional;

/**
 * Renames a wing in the fleet hierarchy.
 */
final public class RenameWingRequest implements PutRequest {
    private final String accessToken;
    private final long fleetID;
    private final long wingID;
    private final String name;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of the
     *                   fleet
     * @param fleetID the ID of the fleet
     * @param wingID the ID of the wing to rename
     * @param name a name no longer than 10 characters
     */
    public RenameWingRequest(final String accessToken, final long fleetID, final long wingID, final String name) {
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.fleetID = fleetID;
        this.wingID = wingID;
        Preconditions.checkArgument(Preconditions.checkNotNull(name).length() <= 10, "New wing name must be 10 or fewer characters");
        this.name = name;
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/wings/%d/", fleetID, wingID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(ImmutableMap.of("name", name));
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
