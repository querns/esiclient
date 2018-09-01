package gbsio.esiclient.api.domain.response.assets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

/**
 * Represents the type of identifier a identifier ID on an asset is describing.
 */
public enum LocationType implements EnumUtil.MappableEnum {
    STATION("station"), SOLAR_SYSTEM("solar_system"), OTHER("other"), UNKNOWN("unknown");

    private final String identifier;
    private static final ImmutableMap<String, LocationType> map = EnumUtil.generateMap(values());

    LocationType(String identifier) {
        this.identifier = identifier;
    }

    @JsonCreator
    public static LocationType of(String argument) {
        return map.getOrDefault(argument, UNKNOWN);
    }

    @Override
    @JsonValue
    public String getIdentifier() {
        return identifier;
    }
}
