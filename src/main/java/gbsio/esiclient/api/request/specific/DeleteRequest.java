package gbsio.esiclient.api.request.specific;

import gbsio.esiclient.api.request.BooleanRequest;
import io.netty.handler.codec.http.HttpMethod;

import java.util.Optional;

/**
 * Represents a request utilizing HTTP method "DELETE".
 */
public interface DeleteRequest extends BooleanRequest {
    @Override
    default HttpMethod getHttpMethod() {
        return HttpMethod.DELETE;
    }

    @Override
    default Optional<Object> getRequestBody() {
        return Optional.empty();
    }
}
