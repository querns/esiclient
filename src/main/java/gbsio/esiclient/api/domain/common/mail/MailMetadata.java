package gbsio.esiclient.api.domain.common.mail;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.ImmutableList;

import java.util.Optional;

/**
 * Represents information used to update a mail's metadata.
 */
public interface MailMetadata {
    /**
     * Assigns new label IDs to the mail.
     *
     * NOTE: The entire set of labels is overwritten by this call. Failure to
     * include any pre-existing label IDs will result in them being removed from
     * this mail.
     *
     * @return 0 to 25 label IDs
     */
    @JsonGetter("labels")
    ImmutableList<Integer> getLabelIDs();

    /**
     * Marks the mail read or unread.
     *
     * @return true if the mail is to be marked as read, false for "unread"
     */
    @JsonGetter("read")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<Boolean> isRead();
}
