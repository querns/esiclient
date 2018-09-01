package gbsio.esiclient.client.request.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.BaseContact;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Requests contacts belonging to an alliance.
 */
final public class AllianceContactsRequest implements GetListRequest<BaseContact, ImmutableList<BaseContact>> {
    private final int allianceID;
    private final String accessToken;

    /**
     * @param allianceID the ID of the alliance to query
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    alliance
     */
    public AllianceContactsRequest(final int allianceID, final String accessToken) {
        this.allianceID = allianceID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/alliances/%d/contacts/", allianceID);
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
