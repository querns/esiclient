package gbsio.esiclient.client.request.mail;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.request.specific.DeleteRequest;

import java.util.Optional;

/**
 * Deletes a mail label belonging to a character.
 */
final public class DeleteLabelRequest implements DeleteRequest {
    private final int characterID;
    private final String accessToken;
    private final int labelID;

    /**
     *
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param labelID the ID of the label to delete
     */
    public DeleteLabelRequest(final int characterID, final String accessToken, final int labelID) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.labelID = labelID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/mail/labels/%d/", characterID, labelID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
