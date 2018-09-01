package gbsio.esiclient.api.domain.response.calendar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

public enum EventResponseType implements EnumUtil.MappableEnum {
    DECLINED("declined"), NOT_RESPONDED("not_responded"), ACCEPTED("accepted"), TENTATIVE("tentative"), UNKNOWN("unknown");

    private final String identifier;
    private final static ImmutableMap<String, EventResponseType> map = EnumUtil.generateMap(values());

    EventResponseType(String identifier) {
        this.identifier = identifier;
    }

    @JsonCreator
    public static EventResponseType of(String argument) {
        return map.getOrDefault(argument, UNKNOWN);
    }

    @Override
    @JsonValue
    public String getIdentifier() {
        return identifier;
    }
}
