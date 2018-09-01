package gbsio.esiclient.client.request.contacts;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.specific.DeleteRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Deletes one or more contacts belonging to a character.
 */
final public class DeleteContactsRequest implements DeleteRequest {
    private final int characterID;
    private final String accessToken;
    private final ImmutableList<Integer> contactIDs;

    /**
     * @param characterID the character whose contacts are to be deleted
     * @param accessToken the authentication token for this character
     * @param contactIDs a list of IDs of contacts to be deleted
     * @throws NullPointerException if contactIDs is null
     * @throws IllegalArgumentException if contactIDs has 0 elements
     */
    public DeleteContactsRequest(final int characterID, final String accessToken, final ImmutableList<Integer> contactIDs) {
        this.accessToken = Preconditions.checkNotNull(accessToken);
        Preconditions.checkNotNull(contactIDs);
        if (contactIDs.size() == 0) {
            throw new IllegalArgumentException("Second argument to DeleteContactsRequest must have one or more list members");
        }

        this.characterID = characterID;
        this.contactIDs = contactIDs;
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/contacts/", characterID);
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of("contact_ids", contactIDs);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
