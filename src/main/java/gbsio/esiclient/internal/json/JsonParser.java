package gbsio.esiclient.internal.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import gbsio.esiclient.internal.http.RawContentResponse;

import java.io.IOException;

/**
 * Parses a successful ESI call into a response object.
 */
public interface JsonParser {
    /**
     * Parses the response, returning the object contained within.
     * @param response the response from ESI
     * @param typeReference a reference to the expected type of object
     * @param <T> the expected type of object
     * @return the expected object
     * @throws IOException if the response's stream is nonfunctional or missing
     * @throws JsonParseException if the input JSON is malformed
     * @throws JsonMappingException if the mapping to {@link T} fails
     */
    <T> T parse(RawContentResponse response, TypeReference<T> typeReference) throws IOException;

    String serialize(Object toBeSerialized) throws JsonProcessingException;
}
