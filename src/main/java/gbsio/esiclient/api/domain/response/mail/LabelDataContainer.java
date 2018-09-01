package gbsio.esiclient.api.domain.response.mail;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.mail.LabelDataContainerImpl;

import java.util.Optional;

/**
 * Represents the character's mail labels, as well as the total unread count for
 * all mail of the character. :ccp:
 */
@JsonDeserialize(as = LabelDataContainerImpl.class)
public interface LabelDataContainer {
    /**
     * Gets the labels defined by the player.
     *
     * @return the labels
     */
    ImmutableList<Label> getLabels();

    /**
     * Gets the total unread mail count for the character's mailbox.
     *
     * :ccp:
     *
     * @return the total unread mail count
     */
    Optional<Integer> getTotalUnreadCount();
}
