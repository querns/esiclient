package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.character.Affiliation;

import java.util.Optional;

public class AffiliationImpl implements Affiliation {
    private final Integer allianceID;
    private final int characterID;
    private final int corporationID;
    private final Integer factionID;

    AffiliationImpl(
        @JsonProperty("alliance_id")
        final Integer allianceID,
        @JsonProperty(value = "character_id", required = true)
        final int characterID,
        @JsonProperty(value = "corporation_id", required = true)
        final int corporationID,
        @JsonProperty("faction_id")
        final Integer factionID
    ) {
        this.allianceID = allianceID;
        this.characterID = characterID;
        this.corporationID = corporationID;
        this.factionID = factionID;
    }

    public Optional<Integer> getAllianceID() {
        return Optional.ofNullable(allianceID);
    }

    public int getCharacterID() {
        return characterID;
    }

    public int getCorporationID() {
        return corporationID;
    }

    public Optional<Integer> getFactionID() {
        return Optional.ofNullable(factionID);
    }
}
