package gbsio.esiclient.client.request.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.fleets.Wing;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about the fleet hierarchy.
 */
final public class FleetHierarchyRequest implements GetRequest<ImmutableList<Wing>> {
    private final String accessToken;
    private final long fleetID;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of a
     *                    fleet
     * @param fleetID the ID of said fleet
     */
    public FleetHierarchyRequest(final String accessToken, final long fleetID) {
        this.fleetID = fleetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/wings/", fleetID);
    }

    @Override
    public TypeReference<ImmutableList<Wing>> getExpectedType() {
        return new TypeReference<ImmutableList<Wing>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
