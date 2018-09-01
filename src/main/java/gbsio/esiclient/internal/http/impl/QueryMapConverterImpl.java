package gbsio.esiclient.internal.http.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.primitives.Primitives;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.internal.http.QueryMapConverter;
import gbsio.esiclient.internal.json.JsonParser;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Singleton
public class QueryMapConverterImpl implements QueryMapConverter {
    private final JsonParser parser;

    @Inject
    QueryMapConverterImpl(final JsonParser parser) {
        this.parser = parser;
    }

    @Override
    public Map<String, List<String>> buildQueryMap(final Map<String, Object> inputMap) throws JsonProcessingException {
        if (null == inputMap || inputMap.isEmpty()) {
            return ImmutableMap.of();
        }

        final ImmutableMap.Builder<String, List<String>> queryBuilder = ImmutableSortedMap.naturalOrder();

        for (final Map.Entry<String, Object> entry : inputMap.entrySet()) {
            queryBuilder.put(
                entry.getKey(),
                ImmutableList.of(parse(entry.getValue()))
            );
        }

        return queryBuilder.build();
    }

    private String parse(Object object) throws JsonProcessingException {
        final Class<?> valueClass = object.getClass();

        if (valueClass.isPrimitive() || Primitives.isWrapperType(valueClass)) {
            return String.valueOf(object);
        } else if (String.class == valueClass) {
            return (String) object;
        } else if (object instanceof List<?>) {
            final boolean isListOfPrimitives = ((List<?>) object).stream().allMatch(o -> o.getClass().isPrimitive() || Primitives.isWrapperType(o.getClass()));
            final boolean isListOfStrings = ((List<?>) object).stream().allMatch(o -> o instanceof String);

            if (isListOfPrimitives) {
                return String.join(
                    ",",
                    ((List<?>) object).stream().map(o -> {
                        try {
                            return parse(o);
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException("Unable to convert something to a string, panic");
                        }
                    }).collect(Collectors.toList())
                );
            } else if (isListOfStrings) {
                // We could technically just cast this as a List<String>, but
                // since it generates an unsafe cast error when using -Xlint,
                // we'll be a little more explicit here just in case

                return ((List<?>)object).stream()
                    .map(o -> {
                        if (o instanceof String) {
                            return (String)o;
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(","))
                    ;
            }
        }

        return parser.serialize(object);
    }
}
