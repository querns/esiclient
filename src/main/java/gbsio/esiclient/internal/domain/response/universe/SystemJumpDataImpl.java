package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.SystemJumpData;

public class SystemJumpDataImpl implements SystemJumpData {
    private final int jumps;
    private final int solarSystemID;

    SystemJumpDataImpl(
        @JsonProperty(value = "ship_jumps", required = true)
        final int jumps,
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID
    ) {
        this.jumps = jumps;
        this.solarSystemID = solarSystemID;
    }

    @Override
    public int getJumps() {
        return jumps;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }
}
