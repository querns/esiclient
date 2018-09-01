package gbsio.esiclient.client.request.mail;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.common.mail.MailMetadata;
import gbsio.esiclient.api.request.specific.PutRequest;
import gbsio.esiclient.client.domain.mail.MailMetadataBuilder;

import java.util.Optional;

/**
 * Updates metadata about a mail.
 */
final public class UpdateMailMetadataRequest implements PutRequest {
    private final int characterID;
    private final String accessToken;
    private final int mailID;
    private final MailMetadata mailMetadata;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param mailID the ID of the mail to update
     * @param mailMetadata the desired changes to the mail's metadata
     * @see MailMetadataBuilder
     */
    public UpdateMailMetadataRequest(final int characterID, final String accessToken, final int mailID, final MailMetadata mailMetadata) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.mailID = mailID;
        this.mailMetadata = mailMetadata;
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/mail/%d/", characterID, mailID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(mailMetadata);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
