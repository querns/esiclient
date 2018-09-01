package gbsio.esiclient.api.domain.response.clones;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.clones.CloneImpl;
import gbsio.esiclient.internal.domain.response.clones.HomeLocationImpl;
import gbsio.esiclient.internal.domain.response.clones.JumpCloneInformationImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents information about a character's jump clones.
 */
@JsonDeserialize(as = JumpCloneInformationImpl.class)
public interface JumpCloneInformation {
    /**
     * Get the clone's home location.
     *
     * @return the home location
     */
    Optional<HomeLocation> getHomeLocation();

    /**
     * Get a list of the character's jump clones.
     *
     * @return a list of jump clones
     */
    ImmutableList<Clone> getJumpClones();

    /**
     * Get the last time the character executed a clone jump.
     *
     * This is used to inform the user when they are next able to execute a
     * jump into one of his or her jump clones.
     *
     * @return the date the character last clone jumped
     */
    Optional<ZonedDateTime> getLastCloneJumpDate();

    /**
     * Get the last time the user remotely changed their home station.
     *
     * @return the date the character last remotely changed their home station.
     */
    Optional<ZonedDateTime> getLastStationChangeDate();

    /**
     * Represents the character's home location.
     */
    @JsonDeserialize(as = HomeLocationImpl.class)
    interface HomeLocation {
        /**
         * Get the location ID for the character's home location.
         *
         * This is also referred to as a character's death clone location.
         *
         * @return the location ID
         */
        Optional<Long> getLocationID();

        /**
         * Get the type of location for the character's home.
         *
         * @return the location type
         */
        Optional<LocationType> getLocationType();
    }

    enum LocationType implements EnumUtil.MappableEnum {
        STATION("station"), STRUCTURE("structure"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, LocationType> map = EnumUtil.generateMap(values());

        LocationType(String identifier) {
            this.identifier = identifier;
        }

        @Override
        @JsonProperty
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static LocationType of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }

    /**
     * Represents a jump clone belonging to the character.
     */
    @JsonDeserialize(as = CloneImpl.class)
    interface Clone {
        /**
         * Get a list of item type IDs representing the implants this jump clone
         * possesses.
         *
         * Only the IDs are returned; further discovery will be required for
         * more information and is not in scope for this function call.
         *
         * @return the list of item type IDs
         * @see gbsio.esiclient.api.domain.response.universe.ItemType
         */
        ImmutableList<Integer> getImplantList();

        /**
         * Get the unique ID for this clone.
         *
         * @return the ID
         */
        int getID();

        /**
         * Get the location ID for this clone.
         *
         * @return the location ID
         */
        long getLocationID();

        /**
         * Get the type of location for this clone.
         *
         * @return the location type
         */
        LocationType getLocationType();

        /**
         * Get the user-defined name for this clone.
         *
         * @return the clone's name
         */
        Optional<String> getName();
    }
}
