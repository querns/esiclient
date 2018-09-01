package gbsio.esiclient.api.domain.request.routes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

import java.util.Optional;

public enum SecurityPreference implements EnumUtil.MappableEnum {
    SHORTEST("shortest"), SECURE("secure"), INSECURE("insecure");

    private final String identifier;
    private final static ImmutableMap<String, SecurityPreference> map = EnumUtil.generateMap(values());

    SecurityPreference(final String identifier) {
        this.identifier = identifier;
    }

    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @JsonCreator
    public static Optional<SecurityPreference> of(String identifier) {
        if (map.containsKey(identifier)) {
            return Optional.of(map.get(identifier));
        }

        return Optional.empty();
    }
}
