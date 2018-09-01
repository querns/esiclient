package gbsio.esiclient.api.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.CustomsOfficeImpl;

import java.util.Optional;

/**
 * Represents a customs office owned by a corporation.
 */
@JsonDeserialize(as = CustomsOfficeImpl.class)
public interface CustomsOffice {
    /**
     * Gets the tax rate charged to alliance members.
     *
     * Only present if {@link #allowAllianceAccess()} is true.
     *
     * @return the alliance tax rate
     */
    Optional<Float> getAllianceTaxRate();

    /**
     * Gets if the customs office allows access based on a character's standings
     * towards the corporation.
     *
     * @return true if standings-based access is allowed
     */
    boolean allowStandingsAccess();

    /**
     * Gets if alliance members are allowed to access this customs office.
     *
     * @return true if alliance members are allowed
     */
    boolean allowAllianceAccess();

    /**
     * Gets the tax rate charged to those with bad (-5) standings.
     *
     * Only present if {@link #allowStandingsAccess()} is true.
     *
     * @return the tax rate charged to Bad standings havers
     */
    Optional<Float> getBadStandingsTaxRate();

    /**
     * Gets the tax rate charged to corporation members.
     *
     * @return the corporation member tax rate
     */
    Optional<Float> getCorporationTaxRate();

    /**
     * Gets the tax rate charged to those with excellent (+10) standings.
     *
     * Only present if {@link #allowStandingsAccess()} is true.
     *
     * @return the tax rate charged to excellent standings havers
     */
    Optional<Float> getExcellentStandingsTaxRate();

    /**
     * Gets the tax rate charged to those with good (+5) standings.
     *
     * Only present if {@link #allowStandingsAccess()} is true.
     *
     * @return the tax rate charged to good standings havers
     */
    Optional<Float> getGoodStandingsTaxRate();

    /**
     * Gets the tax rate charged to those with neutral (0) or no standings.
     *
     * Only present if {@link #allowStandingsAccess()} is true.
     *
     * @return the tax rate charged to neutral standings havers or those with no
     * standings
     */
    Optional<Float> getNeutralStandingsTaxRate();

    /**
     * Gets the unique ID for this customs office.
     *
     * @return the customs office ID
     */
    long getID();

    /**
     * Gets the start of the two-hour window when a customs office may enter its
     * reinforcement cycle.
     *
     * @return the start of the two-hour RF window
     * @see #getReinforceExitEnd()
     */
    int getReinforceExitStart();

    /**
     * Gets the end of the two-hour window when a customs office may exit its
     * reinforcement cycle.
     *
     * @return the exit of the two-hour RF window
     * @see #getReinforceExitStart()
     */
    int getReinforceExitEnd();

    /**
     * Gets the minimum standings needed to use this customs office.
     *
     * @return the minimum standings level
     */
    AllowedStandingLevel getAllowedStandingLevel();

    /**
     * Gets the ID of the solar system where this customs office resides.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the tax rate charged to those with terrible (-10) standings.
     *
     * Only present if {@link #allowStandingsAccess()} is true.
     *
     * @return the tax rate charged to terrible standings havers
     */
    Optional<Float> getTerribleStandingsTaxRate();

    /**
     * Describes the minimum standings required to use a customs office.
     *
     * The ordering of this enum's members coincides with which standings levels
     * are in higher regard than others, and {@link Enum#compareTo(Enum)} will
     * function for comparing them.
     */
    enum AllowedStandingLevel implements EnumUtil.MappableEnum {
        UNKNOWN("unknown"),
        TERRIBLE("terrible"),
        BAD("bad"),
        NEUTRAL("neutral"),
        GOOD("good"),
        EXCELLENT("excellent");

        private final String identifier;
        private static final ImmutableMap<String, AllowedStandingLevel> map = EnumUtil.generateMap(values());

        AllowedStandingLevel(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static AllowedStandingLevel of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
