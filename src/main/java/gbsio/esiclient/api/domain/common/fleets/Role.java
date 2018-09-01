package gbsio.esiclient.api.domain.common.fleets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

/**
 * Represents the role a character fills in a fleet.
 */
public enum Role implements EnumUtil.MappableEnum {
    FLEET_COMMANDER("fleet_commander"), SQUAD_COMMANDER("squad_commander"),
    SQUAD_MEMBER("squad_member"), WING_COMMANDER("wing_commander"),
    UNKNOWN("unknown");

    private final String identifier;
    private static final ImmutableMap<String, Role> map = EnumUtil.generateMap(values());

    Role(String identifier) {
        this.identifier = identifier;
    }

    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @JsonCreator
    public static Role of(String identifier) {
        return map.getOrDefault(identifier, UNKNOWN);
    }
}
