package gbsio.esiclient.api.util;

import com.google.common.collect.ImmutableMap;

/**
 * Provides common methods for Enums.
 */
final public class EnumUtil {
    /**
     * Generates a map for the values of an enum for lookup based on their identifier.
     *
     * This is typically used to store a static map for generating enum values
     * from an identifying string.
     *
     * @param inputs The items that are to be mapped (use {@code values()})
     * @param <V> the enum to be mapped
     *
     * @return an immutable map of the enum's members, keyed to their identifier
     */
    public static <V extends MappableEnum>ImmutableMap<String, V> generateMap(V[] inputs) {
        ImmutableMap.Builder<String, V> builder = ImmutableMap.builder();
        for (V input: inputs) {
            builder.put(input.getIdentifier(), input);
        }

        return builder.build();
    }

    public interface MappableEnum {
        String getIdentifier();
    }
}
