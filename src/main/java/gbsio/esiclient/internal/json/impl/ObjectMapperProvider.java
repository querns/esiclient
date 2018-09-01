package gbsio.esiclient.internal.json.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.google.inject.Provider;
import gbsio.esiclient.internal.json.deserializers.IntUnpackingDeserializer;
import gbsio.esiclient.internal.json.deserializers.LocalDateDeserializer;
import gbsio.esiclient.internal.json.deserializers.LongUnpackingDeserializer;
import gbsio.esiclient.internal.json.deserializers.ZonedDateTimeDeserializer;
import gbsio.esiclient.internal.json.serializers.PairSerializer;
import org.javatuples.Pair;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class ObjectMapperProvider implements Provider<ObjectMapper> {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new GuavaModule());
        objectMapper.registerModule(new Jdk8Module().configureAbsentsAsNulls(false));
        objectMapper.registerModule(new SimpleModule()
            .addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer())
            .addDeserializer(Long.class, new LongUnpackingDeserializer())
            .addDeserializer(Integer.class, new IntUnpackingDeserializer())
            .addDeserializer(LocalDate.class, new LocalDateDeserializer())

            .addSerializer(Pair.class, new PairSerializer())
        );
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public ObjectMapper get() {
        return objectMapper;
    }
}
