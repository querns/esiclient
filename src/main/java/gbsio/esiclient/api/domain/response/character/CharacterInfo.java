package gbsio.esiclient.api.domain.response.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.character.CharacterInfoImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents public EVE character info.
 */
@JsonDeserialize(as = CharacterInfoImpl.class)
public interface CharacterInfo {
    /**
     * Returns the character's corporation ID.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    int getCorporationID();

    /**
     * Get the creation date of the character.
     *
     * @return the character's birthday
     */
    ZonedDateTime getBirthday();

    /**
     * Get the character's name.
     *
     * @return the character's name
     */
    String getName();

    /**
     * Get the character's gender.
     *
     * @return a gender
     */
    Gender getGender();

    /**
     * Get the character's race ID.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the race ID.
     * @see gbsio.esiclient.api.domain.response.universe.Race
     */
    int getRaceID();

    /**
     * Get the character's bloodline ID.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the bloodline ID
     * @see gbsio.esiclient.api.domain.response.universe.Bloodline
     */
    int getBloodlineID();

    /**
     * Get the character's alliance ID, if they are in an alliance.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the alliance ID
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    Optional<Integer> getAllianceID();

    /**
     * Get the character's ancestry ID.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the ancestry ID
     * @see gbsio.esiclient.api.domain.response.universe.Ancestry
     */
    Optional<Integer> getAncestryID();

    /**
     * Get the description for this character.
     *
     * @return the description
     */
    Optional<String> getDescription();

    /**
     * Get the character's faction ID. This is used if the character is enrolled
     * in Faction Warfare to determine which side they are on.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    Optional<Integer> getFactionID();

    /**
     * Get the character's security status. This is used in highsec to determine
     * CONCORD and faction police response.
     *
     * @return the security status, from -10 to 10
     */
    Optional<Float> getSecurityStatus();

    enum Gender implements EnumUtil.MappableEnum {
        MALE("male"), FEMALE("female"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, Gender> map = EnumUtil.generateMap(Gender.values());

        Gender(String identifier) {
            this.identifier = identifier;
        }

        @JsonCreator
        public static Gender of(String argument) {
            return map.getOrDefault(argument, UNKNOWN);
        }

        @Override
        @JsonValue
        public String getIdentifier() {
            return identifier;
        }
    }
}
