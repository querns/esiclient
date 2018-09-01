package gbsio.esiclient.client.request.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.fleets.FleetMember;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about members on a fleet.
 */
final public class FleetMembersRequest implements GetRequest<ImmutableList<FleetMember>> {
    private final String accessToken;
    private final long fleetID;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of the
     *                   fleet
     * @param fleetID the ID of the fleet
     */
    public FleetMembersRequest(final String accessToken, final long fleetID) {
        this.fleetID = fleetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/members/", fleetID);
    }

    @Override
    public TypeReference<ImmutableList<FleetMember>> getExpectedType() {
        return new TypeReference<ImmutableList<FleetMember>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
