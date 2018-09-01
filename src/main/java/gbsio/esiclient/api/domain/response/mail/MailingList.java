package gbsio.esiclient.api.domain.response.mail;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.mail.MailingListImpl;

/**
 * Represents a mailing list that a character is currently subscribed to.
 */
@JsonDeserialize(as = MailingListImpl.class)
public interface MailingList {
    /**
     * Gets the unique ID for this mailing list.
     *
     * @return the mailing list ID
     */
    int getID();

    /**
     * Gets the name of this mailing list.
     *
     * @return the name
     */
    String getName();
}
