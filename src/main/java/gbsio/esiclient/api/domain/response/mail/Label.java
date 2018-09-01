package gbsio.esiclient.api.domain.response.mail;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.common.mail.LabelColor;
import gbsio.esiclient.internal.domain.response.mail.LabelImpl;

import java.util.Optional;

/**
 * Represents a label associated with a mail.
 */
@JsonDeserialize(as = LabelImpl.class)
public interface Label {
    /**
     * Gets the color associated with this label.
     *
     * @return a string containing a color hex
     */
    Optional<LabelColor> getColor();

    /**
     * Gets the unique ID for this label.
     *
     * @return the label ID
     */
    Optional<Integer> getID();

    /**
     * Get the label's name.
     *
     * @return the name
     */
    Optional<String> getName();

    /**
     * Gets the total count of unread mails using this label.
     *
     * @return the unread count
     */
    Optional<Integer> getUnreadCount();
}
