package gbsio.esiclient.client.request.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.BaseContact;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Requests the contacts belonging to a corporation.
 */
final public class CorporationContactsRequest implements GetListRequest<BaseContact, ImmutableList<BaseContact>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character in
     *                    said corporation
     */
    public CorporationContactsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/corporations/%d/contacts/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<BaseContact>> getExpectedType() {
        return new TypeReference<ImmutableList<BaseContact>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
