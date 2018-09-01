package gbsio.esiclient.internal.domain.response.killmails;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.killmails.KillmailIDHash;

public class KillmailIDHashImpl implements KillmailIDHash {
    private final String hash;
    private final int killmailID;

    KillmailIDHashImpl(
        @JsonProperty(value = "killmail_hash", required = true)
        final String hash,
        @JsonProperty(value = "killmail_id", required = true)
        final int killmailID
    ) {
        this.hash = hash;
        this.killmailID = killmailID;
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public int getKillmailID() {
        return killmailID;
    }
}
