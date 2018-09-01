package gbsio.esiclient.client.request.fleets;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.fleets.HierarchyAssignment;
import gbsio.esiclient.api.request.specific.PutRequest;
import gbsio.esiclient.client.domain.fleets.HierarchyAssignmentBuilder;
import gbsio.esiclient.client.validation.fleets.HierarchyAssignmentValidator;

import java.util.Optional;

/**
 * Moves a fleet member to a new position in the fleet hierarchy.
 */
final public class MoveFleetMemberRequest implements PutRequest {
    private final String accessToken;
    private final long fleetID;
    private final int characterID;
    private final HierarchyAssignment newPosition;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of a
     *                    fleet
     * @param fleetID the ID of said fleet
     * @param characterID the ID of the character to move
     * @param newPosition the new position that the character should occupy
     * @see HierarchyAssignmentBuilder
     */
    public MoveFleetMemberRequest(final String accessToken, final long fleetID, final int characterID, final HierarchyAssignment newPosition) {
        this.fleetID = fleetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.characterID = characterID;
        this.newPosition = newPosition;
        HierarchyAssignmentValidator.validate(newPosition, true);
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/members/%d/", fleetID, characterID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(newPosition);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
