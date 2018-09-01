package gbsio.esiclient.client.request.contacts;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.contacts.ContactOperationOptions;
import gbsio.esiclient.api.request.specific.PutRequest;
import gbsio.esiclient.client.domain.contacts.ContactOperationOptionsBuilder;
import gbsio.esiclient.client.validation.contacts.ContactOperationOptionsValidator;

import java.util.Map;
import java.util.Optional;

/**
 * Performs a bulk contacts edit.
 */
final public class EditContactsRequest implements PutRequest {
    private final int characterID;
    private final String accessToken;
    private final ContactOperationOptions options;

    /**
     * @param characterID the ID of the character whose contacts are to be
     *                   edited
     * @param accessToken an OAuth2 access token belonging to said character
     * @param options options describing what contacts to edit and how to edit
     *                them
     * @see ContactOperationOptionsBuilder
     */
    public EditContactsRequest(final int characterID, final String accessToken, final ContactOperationOptions options) {
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
    public Optional<Object> getRequestBody() {
        return options.getRequestBody();
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
