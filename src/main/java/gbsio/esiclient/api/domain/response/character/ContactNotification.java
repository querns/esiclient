package gbsio.esiclient.api.domain.response.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.character.ContactNotificationImpl;

import java.time.ZonedDateTime;

/**
 * Represents a notification sent when a character is added to a contact list.
 */
@JsonDeserialize(as = ContactNotificationImpl.class)
public interface ContactNotification {
    /**
     * Get the user-supplied message sent with this notification.
     *
     * @return the message
     */
    String getMessage();

    /**
     * Get the unique ID for this notification.
     *
     * @return the notification ID
     */
    int getNotificationID();

    /**
     * Get the date that this notification was sent.
     *
     * @return the send date
     */
    ZonedDateTime getSendDate();

    /**
     * Get the character ID of the sender of this notification
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID of the sender
     * @see CharacterInfo
     */
    int getSenderCharacterID();

    /**
     * Get the standing level set to the character.
     *
     * @return a number between -10 (terrible) and 10 (excellent)
     */
    float getStandingLevel();
}
