package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.Bloodline;

public class BloodlineImpl implements Bloodline {
    private final int ID;
    private final int corporationID;
    private final String description;
    private final String name;
    private final int raceID;
    private final int shipItemTypeID;
    private final int charisma;
    private final int intelligence;
    private final int memory;
    private final int perception;
    private final int willpower;

    BloodlineImpl(
        @JsonProperty(value = "bloodline_id", required = true)
        final int ID,
        @JsonProperty(value = "corporation_id", required = true)
        final int corporationID,
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "race_id", required = true)
        final int raceID,
        @JsonProperty(value = "ship_type_id", required = true)
        final int shipItemTypeID,
        @JsonProperty(value = "charisma", required = true)
        final int charisma,
        @JsonProperty(value = "intelligence", required = true)
        final int intelligence,
        @JsonProperty(value = "memory", required = true)
        final int memory,
        @JsonProperty(value = "perception", required = true)
        final int perception,
        @JsonProperty(value = "willpower", required = true)
        final int willpower
    ) {
        this.ID = ID;
        this.corporationID = corporationID;
        this.description = description;
        this.name = name;
        this.raceID = raceID;
        this.shipItemTypeID = shipItemTypeID;
        this.charisma = charisma;
        this.intelligence = intelligence;
        this.memory = memory;
        this.perception = perception;
        this.willpower = willpower;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getCorporationID() {
        return corporationID;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRaceID() {
        return raceID;
    }

    @Override
    public int getShipItemTypeID() {
        return shipItemTypeID;
    }

    @Override
    public int getCharisma() {
        return charisma;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public int getMemory() {
        return memory;
    }

    @Override
    public int getPerception() {
        return perception;
    }

    @Override
    public int getWillpower() {
        return willpower;
    }
}
