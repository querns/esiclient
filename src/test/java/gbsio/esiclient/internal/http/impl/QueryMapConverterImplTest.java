package gbsio.esiclient.internal.http.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.internal.http.QueryMapConverter;
import gbsio.esiclient.internal.json.JsonParser;
import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class QueryMapConverterImplTest {
    private static final int PRIMITIVE_VALUE = 123;
    private static final String VALUE_STRING = String.valueOf(PRIMITIVE_VALUE);
    private static final String KEY = "test_key";
    private static final String STRING = "Test String";
    private static final String SECOND_STRING = "Second Test String";

    @Mock
    private JsonParser parser;

    private QueryMapConverter sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new QueryMapConverterImpl(parser);
    }

    @Test
    void convertPrimitive() throws JsonProcessingException {
        final Map<String, List<String>> returnValue = sut.buildQueryMap(ImmutableMap.of(KEY, PRIMITIVE_VALUE));

        assertTrue(returnValue.containsKey(KEY));
        assertEquals(1, returnValue.size());
        assertTrue(returnValue.get(KEY).contains(VALUE_STRING));
    }

    @Test
    void convertString() throws JsonProcessingException {
        final Map<String, List<String>> returnValue = sut.buildQueryMap(ImmutableMap.of(KEY, STRING));

        assertTrue(returnValue.containsKey(KEY));
        assertEquals(1, returnValue.size());
        assertTrue(returnValue.get(KEY).contains(STRING));
    }

    @Test
    void convertOther() throws JsonProcessingException {
        final Pair<String, String> value = new Pair<>(STRING, SECOND_STRING);
        final String formattedOutput = String.format("[\"%s\", \"%s\"", STRING, SECOND_STRING);

        when(parser.serialize(value)).thenReturn(formattedOutput);

        final Map<String, List<String>> returnValue = sut.buildQueryMap(ImmutableMap.of(KEY, value));

        assertTrue(returnValue.containsKey(KEY));
        verify(parser).serialize(value);
        assertEquals(1, returnValue.size());
        assertTrue(returnValue.get(KEY).contains(formattedOutput));
    }

    @Test
    void parseEmpty() throws JsonProcessingException {
        final Map<String, List<String>> returnValue = sut.buildQueryMap(ImmutableMap.of());
        assertTrue(returnValue.isEmpty());
    }
}