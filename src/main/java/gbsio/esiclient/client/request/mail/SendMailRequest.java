package gbsio.esiclient.client.request.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.mail.NewMail;
import gbsio.esiclient.api.request.specific.PostRequest;
import gbsio.esiclient.client.domain.mail.NewMailBuilder;
import gbsio.esiclient.client.validation.mail.NewMailValidator;

import java.util.Optional;

/**
 * Sends a new mail.
 *
 * Response contains the ID of the mail that was sent.
 */
final public class SendMailRequest implements PostRequest<Integer> {
    private final int characterID;
    private final String accessToken;
    private final NewMail newMail;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param newMail the mail to send
     * @see NewMailBuilder
     */
    public SendMailRequest(final int characterID, final String accessToken, final NewMail newMail) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.newMail = newMail;
        NewMailValidator.validate(newMail);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/mail/", characterID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(newMail);
    }

    @Override
    public TypeReference<Integer> getExpectedType() {
        return new TypeReference<Integer>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
