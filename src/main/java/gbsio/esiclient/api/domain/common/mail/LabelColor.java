package gbsio.esiclient.api.domain.common.mail;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

@SuppressWarnings("SpellCheckingInspection")
public enum LabelColor implements EnumUtil.MappableEnum {
    COLOR_0000fe("#0000fe"),
    COLOR_006634("#006634"),
    COLOR_0099ff("#0099ff"),
    COLOR_00FF33("#00ff33"),
    COLOR_01FFFF("#01ffff"),
    COLOR_349800("#349800"),
    COLOR_660066("#660066"),
    COLOR_666666("#666666"),
    COLOR_999999("#999999"),
    COLOR_99FFFF("#99ffff"),
    COLOR_9a0000("#9a0000"),
    COLOR_CCFF9a("#ccff9a"),
    COLOR_E6E6E6("#e6e6e6"),
    COLOR_FE0000("#fe0000"),
    COLOR_FF6600("#ff6600"),
    COLOR_FFFF01("#ffff01"),
    COLOR_FFFFCD("#ffffcd"),
    COLOR_FFFFFF("#ffffff"),
    UNKNOWN("unknown");

    private final String identifier;
    private final static ImmutableMap<String, LabelColor> map = EnumUtil.generateMap(values());

    LabelColor(final String identifier) {
        this.identifier = identifier;
    }

    @Override
    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @JsonCreator
    private static LabelColor of(String identifier) {
        return map.getOrDefault(identifier, UNKNOWN);
    }
}
