package gbsio.esiclient.api.domain.response.sovereignty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.domain.response.sovereignty.SovereigntyImpl;

import java.util.Optional;

/**
 * Represents information about the sovereignty of a solar system.
 */
@JsonDeserialize(as = SovereigntyImpl.class)
public interface Sovereignty {
    /**
     * Gets the ID of the alliance that owns this system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the alliance ID
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    Optional<Integer> getAllianceID();

    /**
     * Gets the ID of the corporation that owns this system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    Optional<Integer> getCorporationID();

    /**
     * Gets the ID of the faction that owns this system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    Optional<Integer> getFactionID();

    /**
     * Gets the ID of the solar system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();
}
