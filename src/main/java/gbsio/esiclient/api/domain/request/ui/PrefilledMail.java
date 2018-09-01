package gbsio.esiclient.api.domain.request.ui;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.ImmutableList;

import java.util.Optional;

/**
 * Represents information used to pre-fill the in-game mail window.
 */
public interface PrefilledMail {
    /**
     * Gets the body of the mail.
     *
     * @return the body
     */
    @JsonGetter("body")
    String getBody();

    /**
     * Gets a list of IDs of characters to receive the mail.
     *
     * @return 1 to 50 character IDs
     */
    @JsonGetter("recipients")
    ImmutableList<Integer> getRecipients();

    /**
     * Gets the subject of the mail.
     *
     * @return the mail subject
     */
    @JsonGetter("subject")
    String getSubject();

    /**
     * Gets a corporation or alliance ID to receive the mail.
     *
     * You cannot set this and {@link #getMailingListRecipientID()} at the same
     * time.
     *
     * @return a corporation or alliance ID, optionally
     */
    @JsonGetter("to_corp_or_alliance_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<Integer> getCorporationOrAllianceRecipientID();

    /**
     * Gets a mailing list ID to receive the mail.
     *
     * You cannot set this and {@link #getCorporationOrAllianceRecipientID()} at
     * the same time.
     *
     * @return a mailing list ID, optionally
     */
    @JsonGetter("to_mailing_list_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<Integer> getMailingListRecipientID();
}
