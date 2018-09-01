package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Extractor;
import gbsio.esiclient.api.domain.response.planetaryinteraction.LatLon;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Pin;

import java.time.ZonedDateTime;
import java.util.Optional;

public class PinImpl implements Pin {
    private final ImmutableList<ContainedItem> contents;
    private final ZonedDateTime expiryDate;
    private final Extractor extractorDetails;
    private final ZonedDateTime installDate;
    private final ZonedDateTime lastCycleStartDate;
    private final LatLon latLon;
    private final long ID;
    private final Integer schematicID;
    private final int itemTypeID;

    PinImpl(
        @JsonProperty("contents")
        final ImmutableList<ContainedItem> contents,
        @JsonProperty("expiry_time")
        final ZonedDateTime expiryDate,
        @JsonProperty("extractor_details")
        final Extractor extractorDetails,
        @JsonProperty("install_time")
        final ZonedDateTime installDate,
        @JsonProperty("last_cycle_start")
        final ZonedDateTime lastCycleStartDate,
        @JsonProperty(value = "latitude", required = true)
        final float latitude,
        @JsonProperty(value = "longitude", required = true)
        final float longitude,
        @JsonProperty(value = "pin_id", required = true)
        final long id,
        @JsonProperty("schematic_id")
        final Integer schematicID,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID
    ) {
        this.contents = MoreObjects.firstNonNull(contents, ImmutableList.of());
        this.expiryDate = expiryDate;
        this.extractorDetails = extractorDetails;
        this.installDate = installDate;
        this.lastCycleStartDate = lastCycleStartDate;
        this.latLon = new LatLonImpl(latitude, longitude);
        ID = id;
        this.schematicID = schematicID;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public ImmutableList<ContainedItem> getContents() {
        return contents;
    }

    @Override
    public Optional<ZonedDateTime> getExpiryDate() {
        return Optional.ofNullable(expiryDate);
    }

    @Override
    public Optional<Extractor> getExtractorDetails() {
        return Optional.ofNullable(extractorDetails);
    }

    // TODO: Figure out if this is ever passed
    @Override
    public Optional<Integer> getFactorySchematicID() {
        return Optional.empty();
    }

    @Override
    public Optional<ZonedDateTime> getInstallDate() {
        return Optional.ofNullable(installDate);
    }

    @Override
    public Optional<ZonedDateTime> getLastCycleStartDate() {
        return Optional.ofNullable(lastCycleStartDate);
    }

    @Override
    public LatLon getLatLon() {
        return latLon;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public Optional<Integer> getSchematicID() {
        return Optional.ofNullable(schematicID);
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }
}
