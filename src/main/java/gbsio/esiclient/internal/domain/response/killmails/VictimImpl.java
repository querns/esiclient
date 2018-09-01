package gbsio.esiclient.internal.domain.response.killmails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.killmails.Item;
import gbsio.esiclient.api.domain.response.killmails.Victim;

import java.util.Optional;

public class VictimImpl implements Victim {
    private final int damageTaken;
    private final ImmutableList<Item> items;
    private final Coordinates position;
    private final Integer allianceID;
    private final Integer characterID;
    private final Integer corporationID;
    private final Integer factionID;
    private final Integer shipItemTypeID;

    VictimImpl(
        @JsonProperty(value = "damage_taken", required = true)
        final int damageTaken,
        @JsonProperty("items")
        final ImmutableList<Item> items,
        @JsonProperty("position")
        final Coordinates position,
        @JsonProperty("alliance_id")
        final Integer allianceID,
        @JsonProperty("character_id")
        final Integer characterID,
        @JsonProperty("corporation_id")
        final Integer corporationID,
        @JsonProperty("faction_id")
        final Integer factionID,
        @JsonProperty(value = "ship_type_id", required = true)
        final Integer shipItemTypeID
    ) {
        this.damageTaken = damageTaken;
        this.items = MoreObjects.firstNonNull(items, ImmutableList.of());
        this.position = position;
        this.allianceID = allianceID;
        this.characterID = characterID;
        this.corporationID = corporationID;
        this.factionID = factionID;
        this.shipItemTypeID = shipItemTypeID;
    }

    @Override
    public int getDamageTaken() {
        return damageTaken;
    }

    @Override
    public ImmutableList<Item> getItems() {
        return items;
    }

    @Override
    public Coordinates getPosition() {
        return position;
    }

    @Override
    public Optional<Integer> getAllianceID() {
        return Optional.ofNullable(allianceID);
    }

    @Override
    public Optional<Integer> getCharacterID() {
        return Optional.ofNullable(characterID);
    }

    @Override
    public Optional<Integer> getCorporationID() {
        return Optional.ofNullable(corporationID);
    }

    @Override
    public Optional<Integer> getFactionID() {
        return Optional.ofNullable(factionID);
    }

    @Override
    public Optional<Integer> getShipItemTypeID() {
        return Optional.ofNullable(shipItemTypeID);
    }
}
