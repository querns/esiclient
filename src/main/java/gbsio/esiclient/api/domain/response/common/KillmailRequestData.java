package gbsio.esiclient.api.domain.response.common;

/**
 * Represents data needed to fetch information about killmails.
 */
public interface KillmailRequestData {
    /**
     * Get the security hash for this killmail.
     *
     * @return the hash
     */
    String getKillmailHash();

    /**
     * Get the ID for this killmail.
     *
     * @return the ID
     */
    int getKillmailID();
}
