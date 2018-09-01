package gbsio.esiclient.api.domain.response.market;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

/**
 * Describes the reason a market order was completed.
 */
public enum HistoricalOrderState implements EnumUtil.MappableEnum {
    CANCELLED("cancelled"), EXPIRED("expired"), UNKNOWN("unknown");

    private final String identifier;
    private static final ImmutableMap<String, HistoricalOrderState> map = EnumUtil.generateMap(values());

    HistoricalOrderState(String identifier) {
        this.identifier = identifier;
    }

    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @JsonCreator
    public static HistoricalOrderState of(String identifier) {
        return map.getOrDefault(identifier, UNKNOWN);
    }
}
