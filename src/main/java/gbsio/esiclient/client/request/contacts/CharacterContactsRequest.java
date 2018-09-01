package gbsio.esiclient.client.request.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.CharacterContact;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Requests the contacts belonging to a character.
 */
final public class CharacterContactsRequest implements GetListRequest<CharacterContact, ImmutableList<CharacterContact>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public CharacterContactsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/contacts/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<CharacterContact>> getExpectedType() {
        return new TypeReference<ImmutableList<CharacterContact>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
