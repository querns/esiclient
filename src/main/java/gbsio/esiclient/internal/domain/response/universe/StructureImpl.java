package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.universe.Structure;

import java.util.Optional;

public class StructureImpl implements Structure {
    private final int solarSystemID;
    private final Integer itemTypeID;
    private final int ownerCorporationID;
    private final String name;
    private final Coordinates position;

    StructureImpl(
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty("type_id")
        final Integer itemTypeID,
        @JsonProperty(value = "owner_id", required = true)
        final int ownerCorporationID,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty("position")
        final Coordinates position
    ) {
        this.solarSystemID = solarSystemID;
        this.itemTypeID = itemTypeID;
        this.ownerCorporationID = ownerCorporationID;
        this.name = name;
        this.position = position;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public Optional<Integer> getItemTypeID() {
        return Optional.ofNullable(itemTypeID);
    }

    @Override
    public int getOwnerCorporationID() {
        return ownerCorporationID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<Coordinates> getPosition() {
        return Optional.ofNullable(position);
    }
}
