package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.universe.Stargate;

public class StargateImpl implements Stargate {
    private final int destinationStargateID;
    private final int destinationSolarSystemID;
    private final int solarSystemID;
    private final int itemTypeID;
    private final int ID;
    private final String name;
    private final Coordinates position;

    StargateImpl(
        @JsonProperty(value = "destination", required = true)
        final Destination destination,
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID,
        @JsonProperty(value = "stargate_id", required = true)
        final int id,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "position", required = true)
        final Coordinates position
    ) {
        this.destinationStargateID = destination.getStargateID();
        this.destinationSolarSystemID = destination.getSolarSystemID();
        this.solarSystemID = solarSystemID;
        this.itemTypeID = itemTypeID;
        ID = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public int getDestinationStargateID() {
        return destinationStargateID;
    }

    @Override
    public int getDestinationSolarSystemID() {
        return destinationSolarSystemID;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Coordinates getPosition() {
        return position;
    }

    static class Destination {
        private final int stargateID;
        private final int solarSystemID;

        Destination(
            @JsonProperty(value = "stargate_id", required = true)
            final int stargateID,
            @JsonProperty(value = "system_id", required = true)
            final int solarSystemID
        ) {
            this.stargateID = stargateID;
            this.solarSystemID = solarSystemID;
        }

        int getStargateID() {
            return stargateID;
        }

        int getSolarSystemID() {
            return solarSystemID;
        }
    }
}
