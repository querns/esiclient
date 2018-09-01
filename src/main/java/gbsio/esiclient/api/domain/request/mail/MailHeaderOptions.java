package gbsio.esiclient.api.domain.request.mail;

import com.google.common.collect.ImmutableList;

import java.util.Optional;

/**
 * Represents optional arguments for retrieving mail headers.
 */
public interface MailHeaderOptions {
    /**
     * Gets a list of label IDs to use to filter incoming mail headers.
     *
     * @return 0 or more label IDs
     */
    ImmutableList<Integer> getFilterToLabelIDs();

    /**
     * When set, restricts results to mails older than this ID.
     *
     * @return a mail ID, optionally
     */
    Optional<Integer> getLastMailID();
}
