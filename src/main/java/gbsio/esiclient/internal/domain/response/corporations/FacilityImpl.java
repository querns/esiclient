package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.Facility;

public class FacilityImpl implements Facility {
    private final long ID;
    private final int solarSystemID;
    private final int typeID;

    FacilityImpl(
        @JsonProperty(value = "facility_id", required = true)
        final long id,
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "type_id", required = true)
        final int typeID
    ) {
        ID = id;
        this.solarSystemID = solarSystemID;
        this.typeID = typeID;
    }

    public long getID() {
        return ID;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public int getTypeID() {
        return typeID;
    }
}
