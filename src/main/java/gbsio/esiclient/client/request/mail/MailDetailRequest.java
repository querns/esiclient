package gbsio.esiclient.client.request.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.mail.Mail;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves detail about a single mail in a character's mailbox.
 */
final public class MailDetailRequest implements GetRequest<Mail> {
    private final int characterID;
    private final String accessToken;
    private final int mailID;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param mailID the ID of the mail to query
     */
    public MailDetailRequest(final int characterID, final String accessToken, final int mailID) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.mailID = mailID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/mail/%d/", characterID, mailID);
    }

    @Override
    public TypeReference<Mail> getExpectedType() {
        return new TypeReference<Mail>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
