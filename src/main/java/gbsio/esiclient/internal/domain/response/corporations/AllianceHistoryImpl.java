package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.AllianceHistory;

import java.time.ZonedDateTime;
import java.util.Optional;

public class AllianceHistoryImpl implements AllianceHistory {
    private final Integer allianceID;
    private final Boolean isDeleted;
    private final int recordID;
    private final ZonedDateTime startDate;

    AllianceHistoryImpl(
        @JsonProperty("alliance_id")
        final Integer allianceID,
        @JsonProperty("is_deleted")
        final Boolean isDeleted,
        @JsonProperty(value = "record_id", required = true)
        final int recordID,
        @JsonProperty("start_date")
        final ZonedDateTime startDate
    ) {
        this.allianceID = allianceID;
        this.isDeleted = isDeleted;
        this.recordID = recordID;
        this.startDate = startDate;
    }

    @Override
    public Optional<Integer> getAllianceID() {
        return Optional.ofNullable(allianceID);
    }

    @Override
    public Optional<Boolean> isDeleted() {
        return Optional.ofNullable(isDeleted);
    }

    @Override
    public int getRecordID() {
        return recordID;
    }

    @Override
    public ZonedDateTime getStartDate() {
        return startDate;
    }
}
