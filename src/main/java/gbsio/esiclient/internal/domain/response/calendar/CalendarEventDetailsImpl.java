package gbsio.esiclient.internal.domain.response.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.calendar.CalendarEventDetails;
import gbsio.esiclient.api.domain.response.common.SenderType;

import java.time.ZonedDateTime;

public class CalendarEventDetailsImpl implements CalendarEventDetails {
    private final int eventID;
    private final int ownerID;
    private final String ownerName;
    private final ZonedDateTime date;
    private final String title;
    private final int duration;
    private final int importance;
    private final String response;
    private final String text;
    private final SenderType ownerType;

    CalendarEventDetailsImpl(
        @JsonProperty(value = "event_id", required = true)
        final int eventID,
        @JsonProperty(value = "owner_id", required = true)
        final int ownerID,
        @JsonProperty(value = "owner_name", required = true)
        final String ownerName,
        @JsonProperty(value = "date", required = true)
        final ZonedDateTime date,
        @JsonProperty(value = "title", required = true)
        final String title,
        @JsonProperty(value = "duration", required = true)
        final int duration,
        @JsonProperty(value = "importance", required = true)
        final int importance,
        @JsonProperty(value = "response", required = true)
        final String response,
        @JsonProperty(value = "text", required = true)
        final String text,
        @JsonProperty(value = "owner_type", required = true)
        final SenderType ownerType
    ) {
        this.eventID = eventID;
        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.date = date;
        this.title = title;
        this.duration = duration;
        this.importance = importance;
        this.response = response;
        this.text = text;
        this.ownerType = ownerType;
    }

    @Override
    public int getEventID() {
        return eventID;
    }

    @Override
    public int getOwnerID() {
        return ownerID;
    }

    @Override
    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public ZonedDateTime getDate() {
        return date;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getImportance() {
        return importance;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public SenderType getOwnerType() {
        return ownerType;
    }
}
