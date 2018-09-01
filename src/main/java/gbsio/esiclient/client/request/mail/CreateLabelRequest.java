package gbsio.esiclient.client.request.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.mail.NewLabel;
import gbsio.esiclient.api.request.specific.PostRequest;
import gbsio.esiclient.client.domain.mail.NewLabelBuilder;
import gbsio.esiclient.client.validation.mail.NewLabelValidator;

import java.util.Optional;

/**
 * Creates a new mail label for a character.
 *
 * Response contains the ID of the label created.
 */
final public class CreateLabelRequest implements PostRequest<Integer> {
    private final int characterID;
    private final String accessToken;
    private final NewLabel newLabel;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param newLabel the new label to create
     * @see NewLabelBuilder
     */
    public CreateLabelRequest(final int characterID, final String accessToken, final NewLabel newLabel) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        NewLabelValidator.validate(newLabel);
        this.newLabel = newLabel;
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/mail/labels/", characterID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(newLabel);
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
