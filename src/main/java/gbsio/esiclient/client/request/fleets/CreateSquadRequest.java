package gbsio.esiclient.client.request.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.request.specific.PostRequest;

import java.util.Optional;

/**
 * Creates a squad inside of a wing of a fleet.
 *
 * Response contains the ID of the squad that was created.
 */
final public class CreateSquadRequest implements PostRequest<Long> {
    private final String accessToken;
    private final long fleetID;
    private final long wingID;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of a
     *                   fleet
     * @param fleetID the ID of said fleet
     * @param wingID the ID of the wing where the squad will be created
     */
    public CreateSquadRequest(final String accessToken, final long fleetID, final long wingID) {
        this.fleetID = fleetID;
        this.wingID = wingID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/wings/%d/squads/", fleetID, wingID);
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
