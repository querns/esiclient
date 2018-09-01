package gbsio.esiclient.api.domain.response.fleets;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.fleets.FleetImpl;

/**
 * Represents information about a fleet.
 */
@JsonDeserialize(as = FleetImpl.class)
public interface Fleet {
    /**
     * Gets if the fleet has free move enabled.
     *
     * @return true if free move is enabled
     */
    boolean isFreeMove();

    /**
     * Gets if the fleet has registered a fleet advertisement.
     *
     * @return true if the advert is up
     */
    boolean isRegistered();

    /**
     * Gets if the fleet has in-game voice chat enabled.
     *
     * @return true if voice chat is enabled
     */
    boolean isVoiceEnabled();

    /**
     * Gets the user-supplied Message Of The Day (MOTD) for the fleet.
     *
     * MOTDs are in "CCP-flavored HTML."
     *
     * @return the MOTD
     */
    String getMOTD();
}
