package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.universe.Station;

import java.util.Optional;

public class StationImpl implements Station {
    private final float maxDockableShipVolume;
    private final float officeRentalCost;
    private final Integer ownerCorporationID;
    private final Integer raceID;
    private final float reprocessingEfficiency;
    private final float reprocessingTake;
    private final ImmutableSet<Service> services;
    private final int ID;
    private final int solarSystemID;
    private final int itemTypeID;
    private final String name;
    private final Coordinates position;

    StationImpl(
        @JsonProperty(value = "max_dockable_ship_volume", required = true)
        final float maxDockableShipVolume,
        @JsonProperty(value = "office_rental_cost", required = true)
        final float officeRentalCost,
        @JsonProperty("owner")
        final Integer ownerCorporationID,
        @JsonProperty("race_id")
        final Integer raceID,
        @JsonProperty(value = "reprocessing_efficiency", required = true)
        final float reprocessingEfficiency,
        @JsonProperty(value = "reprocessing_stations_take", required = true)
        final float reprocessingTake,
        @JsonProperty(value = "services", required = true)
        final ImmutableSet<Service> services,
        @JsonProperty(value = "station_id", required = true)
        final int ID,
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "position", required = true)
        final Coordinates position
    ) {
        this.maxDockableShipVolume = maxDockableShipVolume;
        this.officeRentalCost = officeRentalCost;
        this.ownerCorporationID = ownerCorporationID;
        this.raceID = raceID;
        this.reprocessingEfficiency = reprocessingEfficiency;
        this.reprocessingTake = reprocessingTake;
        this.services = MoreObjects.firstNonNull(services, ImmutableSet.of());
        this.ID = ID;
        this.solarSystemID = solarSystemID;
        this.itemTypeID = itemTypeID;
        this.name = name;
        this.position = position;
    }

    @Override
    public float getMaxDockableShipVolume() {
        return maxDockableShipVolume;
    }

    @Override
    public float getOfficeRentalCost() {
        return officeRentalCost;
    }

    @Override
    public Optional<Integer> getOwnerCorporationID() {
        return Optional.ofNullable(ownerCorporationID);
    }

    @Override
    public Optional<Integer> getRaceID() {
        return Optional.ofNullable(raceID);
    }

    @Override
    public float getReprocessingEfficiency() {
        return reprocessingEfficiency;
    }

    @Override
    public float getReprocessingTake() {
        return reprocessingTake;
    }

    @Override
    public ImmutableSet<Service> getServices() {
        return services;
    }

    @Override
    public int getID() {
        return ID;
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
    public String getName() {
        return name;
    }

    @Override
    public Coordinates getPosition() {
        return position;
    }
}
