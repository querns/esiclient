package gbsio.esiclient.internal.json.deserializers;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

class ProcessingException extends JsonProcessingException {
    ProcessingException(final String msg, final JsonLocation loc) {
        super(msg, loc);
    }
}
