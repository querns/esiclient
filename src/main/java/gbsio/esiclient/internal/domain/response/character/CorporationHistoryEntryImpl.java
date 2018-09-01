package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.character.CorporationHistoryEntry;

import java.time.ZonedDateTime;
import java.util.Optional;

public class CorporationHistoryEntryImpl implements CorporationHistoryEntry {
    private final int corporationID;
    private final Boolean isDeleted;
    private final int recordID;
    private final ZonedDateTime startDate;

    CorporationHistoryEntryImpl(
        @JsonProperty(value = "corporation_id", required = true)
        final int corporationID,
        @JsonProperty("is_deleted")
        final Boolean isDeleted,
        @JsonProperty(value = "record_id", required = true)
        final int recordID,
        @JsonProperty(value = "start_date", required = true)
        final ZonedDateTime startDate
    ) {
        this.corporationID = corporationID;
        this.isDeleted = isDeleted;
        this.recordID = recordID;
        this.startDate = startDate;
    }

    public int getCorporationID() {
        return corporationID;
    }

    public Optional<Boolean> isDeleted() {
        return Optional.ofNullable(isDeleted);
    }

    public int getRecordID() {
        return recordID;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }
}
