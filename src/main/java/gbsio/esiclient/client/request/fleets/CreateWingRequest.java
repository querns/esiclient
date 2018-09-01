package gbsio.esiclient.client.request.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.request.specific.PostRequest;

import java.util.Optional;

/**
 * Creates a wing inside the fleet hierarchy.
 *
 * Response contains the ID of the wing that was created.
 */
final public class CreateWingRequest implements PostRequest<Long> {
    private final String accessToken;
    private final long fleetID;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of the
     *                   fleet
     * @param fleetID the ID of the fleet in which to create a wing
     */
    public CreateWingRequest(final String accessToken, final long fleetID) {
        this.fleetID = fleetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/wings/", fleetID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.empty();
    }

    @Override
    public TypeReference<Long> getExpectedType() {
        return new TypeReference<Long>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
