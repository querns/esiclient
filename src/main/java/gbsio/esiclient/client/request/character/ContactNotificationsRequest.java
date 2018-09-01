package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.ContactNotification;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Pulls a character's notifications about being added to contact lists
 * belonging to other characters / corporations.
 */
final public class ContactNotificationsRequest implements GetRequest<ImmutableList<ContactNotification>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query contact notifications
     * @param accessToken an OAuth2 access token for said character
     */
    public ContactNotificationsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/notifications/contacts/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<ContactNotification>> getExpectedType() {
        return new TypeReference<ImmutableList<ContactNotification>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
