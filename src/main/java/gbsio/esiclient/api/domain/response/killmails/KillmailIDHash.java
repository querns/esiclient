package gbsio.esiclient.api.domain.response.killmails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.killmails.KillmailIDHashImpl;

/**
 * Represents the ID and hash needed to retrieve a killmail.
 */
@JsonDeserialize(as = KillmailIDHashImpl.class)
public interface KillmailIDHash {
    /**
     * Get the hash that identifies a killmail.
     *
     * @return a hash
     */
    String getHash();

    /**
     * Gets the ID that identifies a killmail.
     *
     * @return the ID
     */
    int getKillmailID();
}
