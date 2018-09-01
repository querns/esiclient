package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.character.Notification;
import gbsio.esiclient.api.domain.response.common.SenderType;

import java.time.ZonedDateTime;
import java.util.Optional;

public class NotificationImpl implements Notification {
    private final long notificationID;
    private final int senderID;
    private final SenderType senderType;
    private final String text;
    private final ZonedDateTime timestamp;
    private final String type;
    private final Boolean isRead;

    NotificationImpl(
        @JsonProperty(value = "notification_id", required = true)
        final long notificationID,
        @JsonProperty(value = "sender_id", required = true)
        final int senderID,
        @JsonProperty(value = "sender_type", required = true)
        final SenderType senderType,
        @JsonProperty(value = "text", required = true)
        final String text,
        @JsonProperty(value = "timestamp", required = true)
        final ZonedDateTime timestamp,
        @JsonProperty(value = "type", required = true)
        final String type,
        @JsonProperty("is_read")
        final Boolean isRead
    ) {
        this.notificationID = notificationID;
        this.senderID = senderID;
        this.senderType = senderType;
        this.text = text;
        this.timestamp = timestamp;
        this.type = type;
        this.isRead = isRead;
    }

    @Override
    public long getNotificationID() {
        return notificationID;
    }

    @Override
    public int getSenderID() {
        return senderID;
    }

    @Override
    public SenderType getSenderType() {
        return senderType;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String getType() {
        return type;
    }

    public Optional<Boolean> isRead() {
        return Optional.ofNullable(isRead);
    }
}
