package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.OwnedStructure;

import java.time.ZonedDateTime;
import java.util.Optional;

public class OwnedStructureImpl implements OwnedStructure {
    private final int corporationID;
    private final ZonedDateTime fuelExpiryDate;
    private final ReinforcementTimer scheduledReinforcementChange;
    private final ReinforcementTimer reinforceTimer;
    private final int aclProfileID;
    private final ImmutableList<Service> services;
    private final StructureState state;
    private final ZonedDateTime stateTimerStart;
    private final ZonedDateTime stateTimerEnd;
    private final long ID;
    private final int itemTypeID;
    private final ZonedDateTime unanchorDate;
    private final int solarSystemID;

    OwnedStructureImpl(
        @JsonProperty(value = "corporation_id", required = true) final int corporationID,
        @JsonProperty("fuel_expires") final ZonedDateTime fuelExpiryDate,
        @JsonProperty("next_reinforce_apply") final ZonedDateTime nextReinforceDate,
        @JsonProperty("next_reinforce_hour") final Integer nextReinforceHour,
        @JsonProperty("next_reinforce_weekday") final Integer nextReinforceWeekday,
        @JsonProperty("reinforce_hour") final int reinforceHour,
        @JsonProperty("reinforce_weekday") final int reinforceWeekday,
        @JsonProperty(value = "profile_id", required = true) final int aclProfileID,
        @JsonProperty("services") final ImmutableList<Service> services,
        @JsonProperty(value = "state", required = true) final StructureState state,
        @JsonProperty("state_timer_start") final ZonedDateTime stateTimerStart,
        @JsonProperty("state_timer_end") final ZonedDateTime stateTimerEnd,
        @JsonProperty(value = "structure_id", required = true) final long id,
        @JsonProperty(value = "type_id", required = true) final int itemTypeID,
        @JsonProperty("unanchors_at") final ZonedDateTime unanchorDate,
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID
    ) {
        this.corporationID = corporationID;
        this.fuelExpiryDate = fuelExpiryDate;
        this.solarSystemID = solarSystemID;

        if (null != nextReinforceHour && null != nextReinforceWeekday) {
            this.scheduledReinforcementChange = new ReinforceTimerImpl(nextReinforceDate, nextReinforceHour, nextReinforceWeekday);
        } else {
            this.scheduledReinforcementChange = null;
        }

        this.reinforceTimer = new ReinforceTimerImpl(reinforceHour, reinforceWeekday);
        this.aclProfileID = aclProfileID;
        this.services = MoreObjects.firstNonNull(services, ImmutableList.of());
        this.state = state;
        this.stateTimerStart = stateTimerStart;
        this.stateTimerEnd = stateTimerEnd;
        this.ID = id;
        this.itemTypeID = itemTypeID;
        this.unanchorDate = unanchorDate;
    }

    @Override
    public int getCorporationID() {
        return corporationID;
    }

    @Override
    public Optional<ZonedDateTime> getFuelExpiryDate() {
        return Optional.ofNullable(fuelExpiryDate);
    }

    @Override
    public Optional<ReinforcementTimer> getScheduledReinforcementChange() {
        return Optional.ofNullable(scheduledReinforcementChange);
    }

    public int getACLProfileID() {
        return aclProfileID;
    }

    @Override
    public ReinforcementTimer getReinforceTimer() {
        return reinforceTimer;
    }

    @Override
    public ImmutableList<Service> getServices() {
        return services;
    }

    @Override
    public StructureState getState() {
        return state;
    }

    @Override
    public Optional<ZonedDateTime> getStateTimerStart() {
        return Optional.ofNullable(stateTimerStart);
    }

    @Override
    public Optional<ZonedDateTime> getStateTimerEnd() {
        return Optional.ofNullable(stateTimerEnd);
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
    public int getSolarSystemID() {
        return solarSystemID;

    }

    @Override
    public Optional<ZonedDateTime> getUnanchorDate() {
        return Optional.ofNullable(unanchorDate);
    }
}
