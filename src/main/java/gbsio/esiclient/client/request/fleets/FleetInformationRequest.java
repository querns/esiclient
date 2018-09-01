package gbsio.esiclient.client.request.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.fleets.Fleet;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about a fleet that the character is currently
 * attending.
 */
final public class FleetInformationRequest implements GetRequest<Fleet> {
    private final String accessToken;
    private final long fleetID;

    /**
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    fleet
     * @param fleetID the ID of the fleet
     */
    public FleetInformationRequest(final String accessToken, final long fleetID) {
        this.fleetID = fleetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/", fleetID);
    }

    @Override
    public TypeReference<Fleet> getExpectedType() {
        return new TypeReference<Fleet>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
