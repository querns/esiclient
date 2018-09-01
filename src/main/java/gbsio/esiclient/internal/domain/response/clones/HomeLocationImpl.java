package gbsio.esiclient.internal.domain.response.clones;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.clones.JumpCloneInformation;

import java.util.Optional;

public class HomeLocationImpl implements JumpCloneInformation.HomeLocation {
    private final Long locationID;
    private final JumpCloneInformation.LocationType locationType;

    HomeLocationImpl(
        @JsonProperty("location_id")
        final Long locationID,
        @JsonProperty("location_type")
        final JumpCloneInformation.LocationType locationType
    ) {
        this.locationID = locationID;
        this.locationType = locationType;
    }

    @Override
    public Optional<Long> getLocationID() {
        return Optional.ofNullable(locationID);
    }

    @Override
    public Optional<JumpCloneInformation.LocationType> getLocationType() {
        return Optional.ofNullable(locationType);
    }
}
