package gbsio.esiclient.client.request.fitting;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.fittings.RetrievedFitting;
import gbsio.esiclient.api.request.specific.DeleteRequest;

import java.util.Optional;

/**
 * Deletes a fitting belonging to a character.
 */
final public class DeleteFittingRequest implements DeleteRequest {
    private final int characterID;
    private final String accessToken;
    private final int fittingID;

    /**
     * @param characterID the ID of the character that owns the doomed fitting
     * @param accessToken an OAuth2 access token belonging to said character
     * @param fittingID the ID of the fitting to be deleted
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public DeleteFittingRequest(final int characterID, final String accessToken, final int fittingID) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.fittingID = fittingID;
    }

    /**
     * @param characterID the ID of the character that owns the doomed fitting
     * @param accessToken an OAuth2 access token belonging to said character
     * @param fitting a fitting retrieved earlier from ESI
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public DeleteFittingRequest(final int characterID, final String accessToken, RetrievedFitting fitting) {
        this(characterID, accessToken, fitting.getID());
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/fittings/%d/", characterID, fittingID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
