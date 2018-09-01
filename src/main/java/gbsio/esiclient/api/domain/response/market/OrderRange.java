package gbsio.esiclient.api.domain.response.market;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

/**
 * Describes the range of a market order.
 */
public enum OrderRange implements EnumUtil.MappableEnum {
    JUMPS_1("1"), JUMPS_10("10"), JUMPS_2("2"), JUMPS_20("20"), JUMPS_3("3"),
    JUMPS_30("30"), JUMPS_4("4"), JUMPS_40("40"), JUMPS_5("5"),
    REGION("region"), @SuppressWarnings("SpellCheckingInspection") SOLAR_SYSTEM("solarsystem"), STATION("station"),
    UNKNOWN("unknown");

    private final String identifier;
    private static final ImmutableMap<String, OrderRange> map = EnumUtil.generateMap(values());

    OrderRange(String identifier) {
        this.identifier = identifier;
    }

    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @JsonCreator
    public static OrderRange of(String identifier) {
        return map.getOrDefault(identifier, UNKNOWN);
    }
}
