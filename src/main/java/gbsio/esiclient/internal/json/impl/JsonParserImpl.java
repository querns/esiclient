package gbsio.esiclient.internal.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.json.JsonParser;

import java.io.IOException;

@Singleton
public class JsonParserImpl implements JsonParser {
    private final ObjectMapper objectMapper;

    @Inject
    JsonParserImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> T parse(RawContentResponse response, TypeReference<T> typeReference) throws IOException {
        if (response.getResponseBody().isPresent()) {
            final String responseBody = response.getResponseBody().get();
            return objectMapper.readValue(responseBody, typeReference);
        } else {
            throw new IOException(
                "Missing response stream when attempting to parse a ".concat(
                    typeReference.getType().toString()
                )
            );
        }

    }

    @Override
    public String serialize(Object toBeSerialized) throws JsonProcessingException {
        return objectMapper.writeValueAsString(toBeSerialized);
    }
}
