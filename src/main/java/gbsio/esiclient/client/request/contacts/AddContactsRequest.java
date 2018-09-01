package gbsio.esiclient.client.request.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.contacts.ContactOperationOptions;
import gbsio.esiclient.api.request.specific.PostRequest;
import gbsio.esiclient.client.domain.contacts.ContactOperationOptionsBuilder;
import gbsio.esiclient.client.validation.contacts.ContactOperationOptionsValidator;

import java.util.Map;
import java.util.Optional;

/**
 * Adds contacts on behalf of a character.
 *
 * Response contains a list of contact IDs that were successfully added.
 */
final public class AddContactsRequest implements PostRequest<ImmutableList<Integer>> {
    private final int characterID;
    private final String accessToken;
    private final ContactOperationOptions options;

    /**
     * @param characterID an ID of a character whose contacts should be appended
     * @param accessToken an OAuth2 access token for said character
     * @param options the options for the contacts addition
     * @see ContactOperationOptionsBuilder
     */
    public AddContactsRequest(final int characterID, final String accessToken, final ContactOperationOptions options) {
        ContactOperationOptionsValidator.validate(options);
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.options = options;
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/contacts/", characterID);
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return options.createQueryParameters();
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }

    @Override
    public Optional<Object> getRequestBody() {
        return options.getRequestBody();
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
