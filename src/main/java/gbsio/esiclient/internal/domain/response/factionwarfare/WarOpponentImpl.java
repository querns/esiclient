package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.WarOpponent;

public class WarOpponentImpl implements WarOpponent {
    private final int againstFactionID;
    private final int factionID;

    WarOpponentImpl(
        @JsonProperty(value = "against_id", required = true)
        final int againstFactionID,
        @JsonProperty(value = "faction_id", required = true)
        final int factionID
    ) {
        this.againstFactionID = againstFactionID;
        this.factionID = factionID;
    }

    @Override
    public int getAgainstFactionID() {
        return againstFactionID;
    }

    @Override
    public int getFactionID() {
        return factionID;
    }
}
