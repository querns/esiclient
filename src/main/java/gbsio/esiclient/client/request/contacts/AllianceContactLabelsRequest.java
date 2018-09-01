package gbsio.esiclient.client.request.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.ContactLabel;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Requests the labels for contacts belonging to an alliance.
 */
final public class AllianceContactLabelsRequest implements GetRequest<ImmutableList<ContactLabel>> {
    private final int allianceID;
    private final String accessToken;

    /**
     * @param allianceID the ID of the alliance to query
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    alliance
     */
    public AllianceContactLabelsRequest(final int allianceID, final String accessToken) {
        this.allianceID = allianceID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/alliances/%d/contacts/labels/", allianceID);
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
