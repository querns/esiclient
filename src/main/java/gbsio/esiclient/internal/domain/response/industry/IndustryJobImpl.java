package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.industry.IndustryJob;

import java.time.ZonedDateTime;
import java.util.Optional;

public class IndustryJobImpl implements IndustryJob {
    private final int activityID;
    private final long blueprintID;
    private final long blueprintLocationID;
    private final int blueprintTypeID;
    private final Integer completedCharacterID;
    private final ZonedDateTime completionDate;
    private final Double cost;
    private final int duration;
    private final ZonedDateTime endDate;
    private final long facilityID;
    private final int installerCharacterID;
    private final int ID;
    private final Integer licensedRuns;
    private final long outputLocationID;
    private final ZonedDateTime pauseDate;
    private final Float probability;
    private final Integer productItemTypeID;
    private final int runs;
    private final ZonedDateTime startDate;
    private final long stationID;
    private final Status status;
    private final Integer successfulRuns;

    IndustryJobImpl(
        @JsonProperty(value = "activity_id", required = true)
        final int activityID,
        @JsonProperty(value = "blueprint_id", required = true)
        final long blueprintID,
        @JsonProperty(value = "blueprint_location_id", required = true)
        final long blueprintLocationID,
        @JsonProperty(value = "blueprint_type_id", required = true)
        final int blueprintTypeID,
        @JsonProperty("completed_character_id")
        final Integer completedCharacterID,
        @JsonProperty("completed_date")
        final ZonedDateTime completionDate,
        @JsonProperty("cost")
        final Double cost,
        @JsonProperty(value = "duration", required = true)
        final int duration,
        @JsonProperty(value = "end_date", required = true)
        final ZonedDateTime endDate,
        @JsonProperty(value = "facility_id", required = true)
        final long facilityID,
        @JsonProperty(value = "installer_id", required = true)
        final int installerCharacterID,
        @JsonProperty(value = "job_id", required = true)
        final int id,
        @JsonProperty("licensed_runs")
        final Integer licensedRuns,
        @JsonProperty(value = "output_location_id", required = true)
        final long outputLocationID,
        @JsonProperty("pause_date")
        final ZonedDateTime pauseDate,
        @JsonProperty("probability")
        final Float probability,
        @JsonProperty("product_type_id")
        final Integer productItemTypeID,
        @JsonProperty(value = "runs", required = true)
        final int runs,
        @JsonProperty(value = "start_date", required = true)
        final ZonedDateTime startDate,
        @JsonProperty(value = "station_id", required = true)
        final long stationID,
        @JsonProperty(value = "status", required = true)
        final Status status,
        @JsonProperty("successful_runs")
        final Integer successfulRuns
    ) {
        this.activityID = activityID;
        this.blueprintID = blueprintID;
        this.blueprintLocationID = blueprintLocationID;
        this.blueprintTypeID = blueprintTypeID;
        this.completedCharacterID = completedCharacterID;
        this.completionDate = completionDate;
        this.cost = cost;
        this.duration = duration;
        this.endDate = endDate;
        this.facilityID = facilityID;
        this.installerCharacterID = installerCharacterID;
        ID = id;
        this.licensedRuns = licensedRuns;
        this.outputLocationID = outputLocationID;
        this.pauseDate = pauseDate;
        this.probability = probability;
        this.productItemTypeID = productItemTypeID;
        this.runs = runs;
        this.startDate = startDate;
        this.stationID = stationID;
        this.status = status;
        this.successfulRuns = successfulRuns;
    }

    @Override
    public int getActivityID() {
        return activityID;
    }

    @Override
    public long getBlueprintID() {
        return blueprintID;
    }

    @Override
    public long getBlueprintLocationID() {
        return blueprintLocationID;
    }

    @Override
    public int getBlueprintTypeID() {
        return blueprintTypeID;
    }

    @Override
    public Optional<Integer> getCompletedCharacterID() {
        return Optional.ofNullable(completedCharacterID);
    }

    @Override
    public Optional<ZonedDateTime> getCompletionDate() {
        return Optional.ofNullable(completionDate);
    }

    @Override
    public Optional<Double> getCost() {
        return Optional.ofNullable(cost);
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public ZonedDateTime getEndDate() {
        return endDate;
    }

    @Override
    public long getFacilityID() {
        return facilityID;
    }

    @Override
    public int getInstallerCharacterID() {
        return installerCharacterID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public Optional<Integer> getLicensedRuns() {
        return Optional.ofNullable(licensedRuns);
    }

    @Override
    public long getOutputLocationID() {
        return outputLocationID;
    }

    @Override
    public Optional<ZonedDateTime> getPauseDate() {
        return Optional.ofNullable(pauseDate);
    }

    @Override
    public Optional<Float> getProbability() {
        return Optional.ofNullable(probability);
    }

    public Optional<Integer> getProductItemTypeID() {
        return Optional.ofNullable(productItemTypeID);
    }

    @Override
    public int getRuns() {
        return runs;
    }

    @Override
    public ZonedDateTime getStartDate() {
        return startDate;
    }

    @Override
    public long getStationID() {
        return stationID;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public Optional<Integer> getSuccessfulRuns() {
        return Optional.ofNullable(successfulRuns);
    }
}
