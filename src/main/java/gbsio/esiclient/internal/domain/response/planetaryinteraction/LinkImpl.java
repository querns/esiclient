package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Link;

public class LinkImpl implements Link {
    private final long destinationPinID;
    private final int upgradeLevel;
    private final long sourcePinID;

    LinkImpl(
        @JsonProperty(value = "destination_pin_id", required = true)
        final long destinationPinID,
        @JsonProperty(value = "link_level", required = true)
        final int upgradeLevel,
        @JsonProperty(value = "source_pin_id", required = true)
        final long sourcePinID
    ) {
        this.destinationPinID = destinationPinID;
        this.upgradeLevel = upgradeLevel;
        this.sourcePinID = sourcePinID;
    }

    @Override
    public long getDestinationPinID() {
        return destinationPinID;
    }

    @Override
    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    @Override
    public long getSourcePinID() {
        return sourcePinID;
    }
}
