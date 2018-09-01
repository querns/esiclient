package gbsio.esiclient.client.request.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.mail.LabelDataContainer;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves the mail labels belonging to a character, as well as unread mail
 * count.
 */
final public class LabelsRequest implements GetRequest<LabelDataContainer> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public LabelsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v3/characters/%d/mail/labels/", characterID);
    }

    @Override
    public TypeReference<LabelDataContainer> getExpectedType() {
        return new TypeReference<LabelDataContainer>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
