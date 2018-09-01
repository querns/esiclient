package gbsio.esiclient.client.request.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.mail.Label;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves mailing lists to which a character is subscribed.
 */
final public class MailingListSubscriptionsRequest implements GetRequest<ImmutableList<Label>> {
    private final int characterID;
    private final String accessToken;

    /**
     *
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public MailingListSubscriptionsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/mail/lists/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<Label>> getExpectedType() {
        return new TypeReference<ImmutableList<Label>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
