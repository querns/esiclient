package gbsio.esiclient.internal.domain.response.sovereignty;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.sovereignty.Campaign;

public class FreeportParticipantImpl implements Campaign.FreeportParticipant {
    private final int allianceID;
    private final float score;

    FreeportParticipantImpl(
        @JsonProperty(value = "alliance_id", required = true)
        final int allianceID,
        @JsonProperty(value = "score", required = true)
        final float score
    ) {
        this.allianceID = allianceID;
        this.score = score;
    }

    @Override
    public int getAllianceID() {
        return allianceID;
    }

    @Override
    public float getScore() {
        return score;
    }
}
