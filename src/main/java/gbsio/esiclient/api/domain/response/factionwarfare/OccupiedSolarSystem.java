package gbsio.esiclient.api.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.factionwarfare.OccupiedSolarSystemImpl;

/**
 * Represents information about the occupation of solar systems at stake in
 * faction warfare.
 */
@JsonDeserialize(as = OccupiedSolarSystemImpl.class)
public interface OccupiedSolarSystem {
    /**
     * Gets if the system is currently being contested.
     *
     * @return true if the system is being contested
     */
    OccupationStatus getStatus();

    /**
     * Get the ID of the faction currently occupying this system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID of the occupier
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    int getOccupierFactionID();

    /**
     * Get the ID of the faction of original owner of this solar system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID of the original owner
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    int getOwnerFactionID();

    /**
     * Get the solar system ID for this system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Get the current victory points gained in pursuit of this system.
     *
     * @return the amount of victory points
     */
    int getVictoryPoints();

    /**
     * Get the victory point threshold.
     *
     * @return the threshold
     */
    int getVictoryPointThreshold();

    enum OccupationStatus implements EnumUtil.MappableEnum {
        CAPTURED("captured"), CONTESTED("contested"), UNCONTESTED("uncontested"), VULNERABLE("vulnerable"), UNKNOWN("unknown");

        private final String identifier;
        private final static ImmutableMap<String, OccupationStatus> map = EnumUtil.generateMap(values());

        @Override
        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        OccupationStatus(final String identifier) {
            this.identifier = identifier;
        }

        @JsonCreator
        public static OccupationStatus of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
