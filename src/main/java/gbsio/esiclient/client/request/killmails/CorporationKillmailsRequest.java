package gbsio.esiclient.client.request.killmails;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.killmails.KillmailIDHash;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves IDs/hashes for killmails generated on behalf of a corporation in
 * the last 90 days.
 */
final public class CorporationKillmailsRequest implements GetListRequest<KillmailIDHash, ImmutableList<KillmailIDHash>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of a corporation to query
     * @param accessToken an OAuth2 access token belonging to a character with
     *                    director roles in said corporation
     */
    public CorporationKillmailsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/killmails/recent/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<KillmailIDHash>> getExpectedType() {
        return new TypeReference<ImmutableList<KillmailIDHash>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
