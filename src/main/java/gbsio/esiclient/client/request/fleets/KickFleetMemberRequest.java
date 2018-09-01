package gbsio.esiclient.client.request.fleets;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.request.specific.DeleteRequest;

import java.util.Optional;

/**
 * Kicks a member from a fleet.
 */
final public class KickFleetMemberRequest implements DeleteRequest {
    private final String accessToken;
    private final long fleetID;
    private final int characterID;

    /**
     * @param accessToken an OAuth2 access token belonging to the boss of a
     *                   fleet
     * @param fleetID the ID of said fleet
     * @param characterID the ID of the character to kick
     */
    public KickFleetMemberRequest(final String accessToken, final long fleetID, final int characterID) {
        this.fleetID = fleetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.characterID = characterID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/fleets/%d/members/%d/", fleetID, characterID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
