package gbsio.esiclient.api.domain.response.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

public enum SenderType implements EnumUtil.MappableEnum {
    EVE_SERVER("eve_server"), CORPORATION("corporation"), FACTION("faction"), CHARACTER("character"),
    ALLIANCE("alliance"), UNKNOWN("unknown");

    private final String identifier;
    private static final ImmutableMap<String, SenderType> map = EnumUtil.generateMap(values());

    SenderType(String identifier) {
        this.identifier = identifier;
    }

    @JsonCreator
    public static SenderType of(String identifier) {
        return map.getOrDefault(identifier, UNKNOWN);
    }

    @Override
    @JsonValue
    public String getIdentifier() {
        return identifier;
    }
}
