package gbsio.esiclient.api.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

/**
 * Describes a type of industry activity performed in an industry facility.
 */
public enum IndustryActivity implements EnumUtil.MappableEnum {
    COPYING("copying"), DUPLICATING("duplicating"), INVENTION("invention"),
    MANUFACTURING("manufacturing"), NONE("none"), REACTION("reaction"),
    RESEARCHING_MATERIAL_EFFICIENCY("researching_material_efficiency"),
    RESEARCHING_TECHNOLOGY("researching_technology"),
    RESEARCHING_TIME_EFFICIENCY("researching_time_efficiency"),
    REVERSE_ENGINEERING("reverse_engineering"), UNKNOWN("unknown");

    private final String identifier;
    private static final ImmutableMap<String, IndustryActivity> map = EnumUtil.generateMap(values());

    IndustryActivity(String identifier) {
        this.identifier = identifier;
    }

    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @JsonCreator
    public static IndustryActivity of(String identifier) {
        return map.getOrDefault(identifier, UNKNOWN);
    }
}
