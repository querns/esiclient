package gbsio.esiclient.client.request.fleets;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.fleets.FleetInvitation;
import gbsio.esiclient.api.request.specific.BooleanPostRequest;
import gbsio.esiclient.client.domain.fleets.FleetInvitationBuilder;
import gbsio.esiclient.client.validation.fleets.HierarchyAssignmentValidator;

import java.util.Optional;

/**
 * Invites a character to a fleet.
 */
final public class FleetInvitationRequest implements BooleanPostRequest {
    private final String accessToken;
    private final long fleetID;
    private final FleetInvitation fleetInvitation;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of a
     *                    fleet
     * @param fleetID the ID of said fleet
     * @param fleetInvitation information about who to invite and what position
     *                        to fill when they accept
     * @see FleetInvitationBuilder
     */
    public FleetInvitationRequest(final String accessToken, final long fleetID, final FleetInvitation fleetInvitation) {
        this.fleetID = fleetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        HierarchyAssignmentValidator.validate(fleetInvitation);
        Preconditions.checkArgument(fleetInvitation.getCharacterID() > 0, "Fleet invitation must have a character ID greater than 0");
        this.fleetInvitation = fleetInvitation;
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/members/", fleetID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(fleetInvitation);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
