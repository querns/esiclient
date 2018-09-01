package gbsio.esiclient.internal.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gbsio.esiclient.internal.json.impl.ObjectMapperProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTestHarness {
    private static final ObjectMapper objectMapper = new ObjectMapperProvider().get();

    /**
     * Deserializes a JSON string.
     *
     * @param json a string containing JSON to be deserialized
     * @throws IOException if json is malformed or missing
     */
    public static <T> T deserialize(String json, TypeReference<T> typeReference) throws IOException {
        return objectMapper.readValue(json, typeReference);
    }

    /**
     * Deserializes JSON in an input stream.
     *
     * @param inputStream a stream containing JSON to be deserialized
     * @throws IOException if the stream's content is malformed or missing
     */
    public static <T> T deserialize(InputStream inputStream, TypeReference<T> typeReference) throws IOException {
        final Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");

        return deserialize(scanner.hasNext() ? scanner.next() : "invalid", typeReference);
    }

    public static JsonNode serializeToNode(Object serializationObject) throws IOException {
        final String json = serialize(serializationObject);
        return objectMapper.reader().readTree(json);
    }

    /**
     * Serializes an object into a JSON string.
     *
     * @param serializationObject an object to be serialized
     * @throws JsonProcessingException if the object cannot be serialized
     */
    public static String serialize(Object serializationObject) throws JsonProcessingException {
        return objectMapper.writeValueAsString(serializationObject);
    }

    /**
     * Performs rote checks on lists deserialized from JSON.
     *
     * forEachObject receives a list index, and the object in that position.
     *
     * @param forEachObject a function to use on each member of the collection
     * @param <T> the type of item inside the collection
     */
    public static <T> void assertForEach(
        Collection<T> collection,
        int expectedSize,
        BiConsumer<Integer, T> forEachObject
    ) {
        Iterator<T> iterator;
        int i = 0;

        assertEquals(expectedSize, collection.size());
        iterator = collection.iterator();

        while (iterator.hasNext()) {
            T member = iterator.next();
            forEachObject.accept(i, member);
            i++;
        }
    }
}