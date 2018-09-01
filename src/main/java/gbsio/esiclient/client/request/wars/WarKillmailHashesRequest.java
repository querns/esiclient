package gbsio.esiclient.client.request.wars;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.killmails.KillmailIDHash;
import gbsio.esiclient.api.request.specific.GetListRequest;

/**
 * Retrieves the ID/hash of killmails generated on account of a war.
 */
final public class WarKillmailHashesRequest implements GetListRequest<KillmailIDHash, ImmutableList<KillmailIDHash>> {
    private final int warID;

    /**
     * @param warID the ID of the war to query
     */
    public WarKillmailHashesRequest(final int warID) {
        this.warID = warID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/wars/%d/killmails/", warID);
    }

    @Override
    public TypeReference<ImmutableList<KillmailIDHash>> getExpectedType() {
        return new TypeReference<ImmutableList<KillmailIDHash>>() {
        };
    }
}
