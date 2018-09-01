package gbsio.esiclient.api.request.specific;

import gbsio.esiclient.api.request.BooleanRequest;
import io.netty.handler.codec.http.HttpMethod;

/**
 * Represents a request of HTTP method "PUT".
 */
public interface PutRequest extends BooleanRequest {
    @Override
    default HttpMethod getHttpMethod() {
        return HttpMethod.PUT;
    }
}
