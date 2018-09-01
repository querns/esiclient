package gbsio.esiclient.client.request.mail;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.request.specific.DeleteRequest;

import java.util.Optional;

/**
 * Deletes a mail.
 */
final public class DeleteMailRequest implements DeleteRequest {
    private final int characterID;
    private final String accessToken;
    private final int mailID;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param mailID the ID of the mail to delete
     */
    public DeleteMailRequest(final int characterID, final String accessToken, final int mailID) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.mailID = mailID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/mail/%d/", characterID, mailID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
