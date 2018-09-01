package gbsio.esiclient.internal.domain.response.killmails;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.killmails.Attacker;

import java.util.Optional;

public class AttackerImpl implements Attacker {
    private final int damageDone;
    private final boolean dealtFinalBlow;
    private final float securityStatus;
    private final Integer weaponItemTypeID;
    private final Integer allianceID;
    private final Integer characterID;
    private final Integer corporationID;
    private final Integer factionID;
    private final Integer shipItemTypeID;

    AttackerImpl(
        @JsonProperty(value = "damage_done", required = true)
        final int damageDone,
        @JsonProperty(value = "final_blow", required = true)
        final boolean dealtFinalBlow,
        @JsonProperty(value = "security_status", required = true)
        final float securityStatus,
        @JsonProperty("weapon_type_id")
        final Integer weaponItemTypeID,
        @JsonProperty("alliance_id")
        final Integer allianceID,
        @JsonProperty("character_id")
        final Integer characterID,
        @JsonProperty("corporation_id")
        final Integer corporationID,
        @JsonProperty("faction_id")
        final Integer factionID,
        @JsonProperty("ship_type_id")
        final Integer shipItemTypeID
    ) {
        this.damageDone = damageDone;
        this.dealtFinalBlow = dealtFinalBlow;
        this.securityStatus = securityStatus;
        this.weaponItemTypeID = weaponItemTypeID;
        this.allianceID = allianceID;
        this.characterID = characterID;
        this.corporationID = corporationID;
        this.factionID = factionID;
        this.shipItemTypeID = shipItemTypeID;
    }

    @Override
    public int getDamageDone() {
        return damageDone;
    }

    public boolean dealtFinalBlow() {
        return dealtFinalBlow;
    }

    @Override
    public float getSecurityStatus() {
        return securityStatus;
    }

    @Override
    public Optional<Integer> getWeaponItemTypeID() {
        return Optional.ofNullable(weaponItemTypeID);
    }

    @Override
    public Optional<Integer> getAllianceID() {
        return Optional.ofNullable(allianceID);
    }

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
