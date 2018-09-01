package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.SystemKillData;

public class SystemKillDataImpl implements SystemKillData {
    private final int npcKills;
    private final int podKills;
    private final int shipKills;
    private final int solarSystemID;

    SystemKillDataImpl(
        @JsonProperty(value = "npc_kills", required = true)
        final int npcKills,
        @JsonProperty(value = "pod_kills", required = true)
        final int podKills,
        @JsonProperty(value = "ship_kills", required = true)
        final int shipKills,
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID
    ) {
        this.npcKills = npcKills;
        this.podKills = podKills;
        this.shipKills = shipKills;
        this.solarSystemID = solarSystemID;
    }

    public int getNPCKills() {
        return npcKills;
    }

    @Override
    public int getPodKills() {
        return podKills;
    }

    @Override
    public int getShipKills() {
        return shipKills;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }
}
