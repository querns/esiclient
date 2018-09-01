package gbsio.esiclient.api.domain.response.mail;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.common.mail.Recipient;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.internal.domain.response.mail.MailHeaderImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents headers for mails belonging to a character.
 */
@JsonDeserialize(as = MailHeaderImpl.class)
public interface MailHeader {
    /**
     * Gets the ID of the character sending the mail.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID of the sender of the mail
     * @see CharacterInfo
     */
    Optional<Integer> getSenderCharacterID();

    /**
     * Gets whether the mail has been read.
     *
     * @return true if the mail has been read
     */
    Optional<Boolean> isRead();

    /**
     * Gets the IDs of the labels assigned to this mail.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more label IDs
     * @see Label
     */
    ImmutableList<Integer> getLabelIDs();

    /**
     * Gets the ID of the mail this header is describing.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the mail ID
     * @see Mail
     */
    Optional<Integer> getMailID();

    /**
     * Gets the recipients of the mail.
     *
     * @return 0 or more recipients
     */
    ImmutableList<Recipient> getRecipients();

    /**
     * Gets the subject of the mail.
     *
     * @return the subject
     */
    Optional<String> getSubject();

    /**
     * Gets the date the mail was sent.
     *
     * @return the send date
     */
    Optional<ZonedDateTime> getDate();
}
