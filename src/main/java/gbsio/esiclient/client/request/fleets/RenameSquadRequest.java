package gbsio.esiclient.client.request.fleets;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.specific.PutRequest;

import java.util.Optional;

/**
 * Renames a squad in a fleet.
 */
final public class RenameSquadRequest implements PutRequest {
    private final String accessToken;
    private final long fleetID;
    private final long squadID;
    private final String name;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of a
     *                    fleet
     * @param fleetID the ID of said fleet
     * @param squadID the ID of the squad to rename
     * @param name a name not exceeding 10 characters
     */
    public RenameSquadRequest(final String accessToken, final long fleetID, final long squadID, final String name) {
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.fleetID = fleetID;
        this.squadID = squadID;
        Preconditions.checkArgument(Preconditions.checkNotNull(name).length() <= 10, "New squad name must be 10 or fewer characters");
        this.name = name;
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/squads/%d/", fleetID, squadID);
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
