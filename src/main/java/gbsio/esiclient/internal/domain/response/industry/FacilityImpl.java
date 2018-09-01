package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.industry.Facility;

import java.util.Optional;

public class FacilityImpl implements Facility {
    private final long ID;
    private final int ownerID;
    private final int regionID;
    private final int solarSystemID;
    private final Float taxRate;
    private final int facilityTypeID;

    FacilityImpl(
        @JsonProperty(value = "facility_id", required = true)
        final long id,
        @JsonProperty(value = "owner_id", required = true)
        final int ownerID,
        @JsonProperty(value = "region_id", required = true)
        final int regionID,
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty("tax")
        final Float taxRate,
        @JsonProperty(value = "type_id", required = true)
        final int facilityTypeID
    ) {
        ID = id;
        this.ownerID = ownerID;
        this.regionID = regionID;
        this.solarSystemID = solarSystemID;
        this.taxRate = taxRate;
        this.facilityTypeID = facilityTypeID;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public int getOwnerID() {
        return ownerID;
    }

    @Override
    public int getRegionID() {
        return regionID;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public Optional<Float> getTaxRate() {
        return Optional.ofNullable(taxRate);
    }

    @Override
    public int getFacilityTypeID() {
        return facilityTypeID;
    }
}
