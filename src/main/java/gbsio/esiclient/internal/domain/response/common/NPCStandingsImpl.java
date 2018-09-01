package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.NPCStandings;

public class NPCStandingsImpl implements NPCStandings {
    private final int id;
    private final NPCStandings.NPCType type;
    private final float standing;

    NPCStandingsImpl(
        @JsonProperty(value = "from_id", required = true)
        final int id,
        @JsonProperty(value = "from_type", required = true)
        final NPCStandings.NPCType type,
        @JsonProperty(value = "standing", required = true)
        final float standing
    ) {
        this.id = id;
        this.type = type;
        this.standing = standing;
    }

    public int getID() {
        return id;
    }

    public NPCStandings.NPCType getType() {
        return type;
    }

    public float getStanding() {
        return standing;
    }
}
