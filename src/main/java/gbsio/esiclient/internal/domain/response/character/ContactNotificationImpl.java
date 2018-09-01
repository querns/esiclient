package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.character.ContactNotification;

import java.time.ZonedDateTime;

public class ContactNotificationImpl implements ContactNotification {
    private final String message;
    private final int notificationID;
    private final ZonedDateTime sendDate;
    private final int senderCharacterID;
    private final float standingLevel;

    ContactNotificationImpl(
        @JsonProperty(value = "message", required = true)
        final String message,
        @JsonProperty(value = "notification_id", required = true)
        final int notificationID,
        @JsonProperty(value = "send_date", required = true)
        final ZonedDateTime sendDate,
        @JsonProperty(value = "sender_character_id", required = true)
        final int senderCharacterID,
        @JsonProperty(value = "standing_level", required = true)
        final float standingLevel
    ) {
        this.message = message;
        this.notificationID = notificationID;
        this.sendDate = sendDate;
        this.senderCharacterID = senderCharacterID;
        this.standingLevel = standingLevel;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getNotificationID() {
        return notificationID;
    }

    @Override
    public ZonedDateTime getSendDate() {
        return sendDate;
    }

    @Override
    public int getSenderCharacterID() {
        return senderCharacterID;
    }

    @Override
    public float getStandingLevel() {
        return standingLevel;
    }
}
