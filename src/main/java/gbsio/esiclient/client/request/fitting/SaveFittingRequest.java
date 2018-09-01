package gbsio.esiclient.client.request.fitting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.common.fittings.Fitting;
import gbsio.esiclient.api.request.specific.PostRequest;
import gbsio.esiclient.client.domain.fitting.FittingBuilder;

import java.util.Optional;

/**
 * Saves a ship fitting to the EVE server.
 *
 * Response contains the ID of the fit that was created.
 */
final public class SaveFittingRequest implements PostRequest<Integer> {
    private final int characterID;
    private final String accessToken;
    private final Fitting newFitting;

    /**
     * Requests that a new fitting be added to the EVE server.
     * @param characterID the ID of the character for whom the fitting should be
     *                   saved
     * @param accessToken an OAuth2 access token for said character
     * @param newFitting the new fitting to be added
     * @see FittingBuilder
     */
    public SaveFittingRequest(final int characterID, final String accessToken, final Fitting newFitting) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.newFitting = newFitting;
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/fittings/", characterID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(newFitting);
    }

    @Override
    public TypeReference<Integer> getExpectedType() {
        return new TypeReference<Integer>() { };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
