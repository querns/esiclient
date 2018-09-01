package gbsio.esiclient.internal.domain.response.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.calendar.EventSummary;
import gbsio.esiclient.api.domain.response.calendar.EventResponseType;

import java.time.ZonedDateTime;
import java.util.Optional;

public class EventSummaryImpl implements EventSummary {
    private final ZonedDateTime eventDate;
    private final Integer eventID;
    private final EventResponseType eventResponse;
    private final Integer importance;
    private final String title;

    EventSummaryImpl(
        @JsonProperty("event_date")
        final ZonedDateTime eventDate,
        @JsonProperty("event_id")
        final Integer eventID,
        @JsonProperty("event_response")
        final EventResponseType eventResponse,
        @JsonProperty("importance")
        final Integer importance,
        @JsonProperty("title")
        final String title
    ) {
        this.eventDate = eventDate;
        this.eventID = eventID;
        this.eventResponse = eventResponse;
        this.importance = importance;
        this.title = title;
    }

    public Optional<ZonedDateTime> getEventDate() {
        return Optional.ofNullable(eventDate);
    }

    public Optional<Integer> getEventID() {
        return Optional.ofNullable(eventID);
    }

    public Optional<EventResponseType> getEventResponse() {
        return Optional.ofNullable(eventResponse);
    }

    public Optional<Integer> getImportance() {
        return Optional.ofNullable(importance);
    }

    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }
}
