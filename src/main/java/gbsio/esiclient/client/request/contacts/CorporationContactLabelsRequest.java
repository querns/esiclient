package gbsio.esiclient.client.request.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.ContactLabel;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Requests the labels for contacts belonging to a corporation.
 */
final public class CorporationContactLabelsRequest implements GetRequest<ImmutableList<ContactLabel>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character in
     *                    said corporation
     */
    public CorporationContactLabelsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/contacts/labels/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<ContactLabel>> getExpectedType() {
        return new TypeReference<ImmutableList<ContactLabel>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
