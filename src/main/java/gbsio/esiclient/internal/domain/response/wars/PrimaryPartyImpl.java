package gbsio.esiclient.internal.domain.response.wars;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.wars.PrimaryParty;

import java.util.Optional;

public class PrimaryPartyImpl implements PrimaryParty {
    private final float ISKDestroyed;
    private final int shipKillCount;
    private final Integer allianceID;
    private final Integer corporationID;

    PrimaryPartyImpl(
        @JsonProperty(value = "isk_destroyed", required = true)
        final float ISKDestroyed,
        @JsonProperty(value = "ships_killed", required = true)
        final int shipKillCount,
        @JsonProperty("alliance_id")
        final Integer allianceID,
        @JsonProperty("corporation_id")
        final Integer corporationID
    ) {
        this.ISKDestroyed = ISKDestroyed;
        this.shipKillCount = shipKillCount;
        this.allianceID = allianceID;
        this.corporationID = corporationID;
    }

    @Override
    public float getISKDestroyed() {
        return ISKDestroyed;
    }

    @Override
    public int getShipKillCount() {
        return shipKillCount;
    }

    @Override
    public Optional<Integer> getAllianceID() {
        return Optional.ofNullable(allianceID);
    }

    @Override
    public Optional<Integer> getCorporationID() {
        return Optional.ofNullable(corporationID);
    }
}
