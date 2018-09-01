package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.universe.IDtoNameResultsImpl;

/**
 * Represents results from a bulk ID-to-name lookup.
 */
@JsonDeserialize(as = IDtoNameResultsImpl.class)
public interface IDtoNameResults {
    /**
     * Gets the type of result.
     *
     * @return the result category
     */
    Category getCategory();

    /**
     * Gets the unique ID for this result.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets the name for this result.
     *
     * @return the name
     */
    String getName();

    enum Category implements EnumUtil.MappableEnum {
        ALLIANCE("alliance"), CHARACTER("character"), CONSTELLATION("constellation"),
        CORPORATION("corporation"), INVENTORY_TYPE("inventory_type"), REGION("region"),
        SOLAR_SYSTEM("solar_system"), STATION("station"), UNKNOWN("unknown");

        private final String identifier;
        private final static ImmutableMap<String, Category> map = EnumUtil.generateMap(values());

        Category(final String identifier) {
            this.identifier = identifier;
        }

        @Override
        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static Category of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
