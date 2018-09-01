package gbsio.esiclient.internal.domain.response.clones;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.clones.JumpCloneInformation;

import java.util.Optional;

public class CloneImpl implements JumpCloneInformation.Clone {
    private final ImmutableList<Integer> implantList;
    private final int ID;
    private final long locationID;
    private final JumpCloneInformation.LocationType locationType;
    private final String name;

    CloneImpl(
        @JsonProperty(value = "implants", required = true)
        final ImmutableList<Integer> implantList,
        @JsonProperty(value = "jump_clone_id", required = true)
        final int id,
        @JsonProperty(value = "location_id", required = true)
        final long locationID,
        @JsonProperty(value = "location_type", required = true)
        final JumpCloneInformation.LocationType locationType,
        @JsonProperty("name")
        final String name
    ) {
        this.implantList = implantList;
        ID = id;
        this.locationID = locationID;
        this.locationType = locationType;
        this.name = name;
    }

    @Override
    public ImmutableList<Integer> getImplantList() {
        return implantList;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public long getLocationID() {
        return locationID;
    }

    @Override
    public JumpCloneInformation.LocationType getLocationType() {
        return locationType;
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
