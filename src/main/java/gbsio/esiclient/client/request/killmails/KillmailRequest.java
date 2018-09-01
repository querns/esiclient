package gbsio.esiclient.client.request.killmails;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.killmails.Killmail;
import gbsio.esiclient.api.domain.response.killmails.KillmailIDHash;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about a killmail.
 */
final public class KillmailRequest implements GetRequest<Killmail> {
    private final int id;
    private final String hash;

    @SuppressWarnings("unused")
    public KillmailRequest(KillmailIDHash idHash) {
        this.id = idHash.getKillmailID();
        this.hash = idHash.getHash();
    }

    @SuppressWarnings("unused")
    public KillmailRequest(final int id, final String hash) {
        this.id = id;
        this.hash = hash;
    }

    @Override
    public String getURL() {
        return String.format("/v1/killmails/%d/%s/", id, hash);
    }

    @Override
    public TypeReference<Killmail> getExpectedType() {
        return new TypeReference<Killmail>() {
        };
    }
}
