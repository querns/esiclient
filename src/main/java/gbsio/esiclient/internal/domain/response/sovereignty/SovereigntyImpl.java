package gbsio.esiclient.internal.domain.response.sovereignty;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.sovereignty.Sovereignty;

import java.util.Optional;

public class SovereigntyImpl implements Sovereignty {
    private final Integer allianceID;
    private final Integer corporationID;
    private final Integer factionID;
    private final int solarSystemID;

    SovereigntyImpl(
        @JsonProperty("alliance_id")
        final Integer allianceID,
        @JsonProperty("corporation_id")
        final Integer corporationID,
        @JsonProperty("faction_id")
        final Integer factionID,
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID
    ) {
        this.allianceID = allianceID;
        this.corporationID = corporationID;
        this.factionID = factionID;
        this.solarSystemID = solarSystemID;
    }

    @Override
    public Optional<Integer> getAllianceID() {
        return Optional.ofNullable(allianceID);
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
    public int getSolarSystemID() {
        return solarSystemID;
    }
}
