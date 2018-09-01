package gbsio.esiclient.api.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.ColonySummaryImpl;

import java.time.ZonedDateTime;

/**
 * Represents summary information about PI colonies.
 */
@JsonDeserialize(as = ColonySummaryImpl.class)
public interface ColonySummary {
    /**
     * Gets the last time the character observed their colony in-game.
     *
     * PI is a deterministic simulation and is not updated by the server until
     * the colony is observed in-game.
     *
     * @return the last update date
     */
    ZonedDateTime getLastUpdateDate();

    /**
     * Gets the number of buildings ("pins") placed on this colony.
     *
     * @return the pin count
     */
    int getPinCount();

    /**
     * Gets the ID of the owner of this colony.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the owner ID
     * @see CharacterInfo
     */
    int getOwnerID();

    /**
     * Gets the ID of the planet housing this colony.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the planet ID
     * @see gbsio.esiclient.api.domain.response.universe.Planet
     */
    int getPlanetID();

    /**
     * Gets the type of planet.
     *
     * @return the planet type
     */
    PlanetType getPlanetType();

    /**
     * Get the ID of the solar system where this colony resides.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the upgrade level of this colony.
     *
     * @return an upgrade level between 0 and 5
     */
    int getUpgradeLevel();

    /**
     * Describes a type of planet.
     *
     * The planet type determines what buildings may exist on and what products
     * may be produced by a planet.
     */
    enum PlanetType implements EnumUtil.MappableEnum {
        TEMPERATE("temperate"), BARREN("barren"), OCEANIC("oceanic"),
        ICE("ice"), GAS("gas"), LAVA("lava"), STORM("storm"), PLASMA("plasma"),
        UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, PlanetType> map = EnumUtil.generateMap(values());

        PlanetType(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static PlanetType of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
