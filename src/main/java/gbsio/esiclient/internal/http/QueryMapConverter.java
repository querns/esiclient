package gbsio.esiclient.internal.http;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface QueryMapConverter {
    Map<String, List<String>> buildQueryMap(Map<String, Object> inputMap) throws JsonProcessingException;
}
