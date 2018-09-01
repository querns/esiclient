package gbsio.esiclient.internal.domain.response.fleets;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.fleets.Fleet;

public class FleetImpl implements Fleet {
    private final boolean freeMove;
    private final boolean registered;
    private final boolean voiceEnabled;
    private final String motd;

    FleetImpl(
        @JsonProperty(value = "is_free_move", required = true)
        final boolean freeMove,
        @JsonProperty(value = "is_registered", required = true)
        final boolean registered,
        @JsonProperty(value = "is_voice_enabled", required = true)
        final boolean voiceEnabled,
        @JsonProperty(value = "motd", required = true)
        final String motd
    ) {
        this.freeMove = freeMove;
        this.registered = registered;
        this.voiceEnabled = voiceEnabled;
        this.motd = motd;
    }

    @Override
    public boolean isFreeMove() {
        return freeMove;
    }

    @Override
    public boolean isRegistered() {
        return registered;
    }

    @Override
    public boolean isVoiceEnabled() {
        return voiceEnabled;
    }

    public String getMOTD() {
        return motd;
    }
}
