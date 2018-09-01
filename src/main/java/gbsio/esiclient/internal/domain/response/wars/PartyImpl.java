package gbsio.esiclient.internal.domain.response.wars;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.wars.Party;

import java.util.Optional;

public class PartyImpl implements Party {
    private final Integer allianceID;
    private final Integer corporationID;

    PartyImpl(
        @JsonProperty("alliance_id")
        final Integer allianceID,
        @JsonProperty("corporation_id")
        final Integer corporationID
    ) {
        this.allianceID = allianceID;
        this.corporationID = corporationID;
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
