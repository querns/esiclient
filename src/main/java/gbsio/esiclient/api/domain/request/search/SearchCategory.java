package gbsio.esiclient.api.domain.request.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

import java.util.Optional;

public enum SearchCategory implements EnumUtil.MappableEnum {
    AGENT("agent"), ALLIANCE("alliance"), CHARACTER("character"),
    CONSTELLATION("constellation"), CORPORATION("corporation"),
    FACTION("faction"), INVENTORY_TYPE("inventory_type"), REGION("region"),
    SOLAR_SYSTEM("solar_system"), STATION("station"), STRUCTURE("structure");

    private final String identifier;
    private final static ImmutableMap<String, SearchCategory> map = EnumUtil.generateMap(values());

    SearchCategory(final String identifier) {
        this.identifier = identifier;
    }

    @Override
    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @JsonCreator
    public static Optional<SearchCategory> of(String identifier) {
        if (map.containsKey(identifier)) {
            return Optional.of(map.get(identifier));
        }

        return Optional.empty();
    }
}
