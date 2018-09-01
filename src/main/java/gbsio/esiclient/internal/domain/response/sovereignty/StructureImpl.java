package gbsio.esiclient.internal.domain.response.sovereignty;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.sovereignty.Structure;

import java.time.ZonedDateTime;
import java.util.Optional;

public class StructureImpl implements Structure {
    private final int allianceID;
    private final int solarSystemID;
    private final long ID;
    private final int itemTypeID;
    private final Float activityDefenseMultiplier;
    private final ZonedDateTime vulnerableStartDate;
    private final ZonedDateTime vulnerableEndDate;

    StructureImpl(
        @JsonProperty(value = "alliance_id", required = true)
        final int allianceID,
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "structure_id", required = true)
        final long id,
        @JsonProperty(value = "structure_type_id", required = true)
        final int itemTypeID,
        @JsonProperty("vulnerability_occupancy_level")
        final Float activityDefenseMultiplier,
        @JsonProperty("vulnerable_start_time")
        final ZonedDateTime vulnerableStartDate,
        @JsonProperty("vulnerable_end_time")
        final ZonedDateTime vulnerableEndDate
    ) {
        this.allianceID = allianceID;
        this.solarSystemID = solarSystemID;
        ID = id;
        this.itemTypeID = itemTypeID;
        this.activityDefenseMultiplier = activityDefenseMultiplier;
        this.vulnerableStartDate = vulnerableStartDate;
        this.vulnerableEndDate = vulnerableEndDate;
    }

    @Override
    public int getAllianceID() {
        return allianceID;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }

    @Override
    public Optional<Float> getActivityDefenseMultiplier() {
        return Optional.ofNullable(activityDefenseMultiplier);
    }

    @Override
    public Optional<ZonedDateTime> getVulnerableStartDate() {
        return Optional.ofNullable(vulnerableStartDate);
    }

    @Override
    public Optional<ZonedDateTime> getVulnerableEndDate() {
        return Optional.ofNullable(vulnerableEndDate);
    }
}
