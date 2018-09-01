package gbsio.esiclient.api.request.specific;

import gbsio.esiclient.api.request.Request;
import io.netty.handler.codec.http.HttpMethod;

import java.util.Optional;

/**
 * Shortcut for a request using HTTP method "GET".
 * @param <T> the expected return type
 */
public interface GetRequest<T> extends Request<T> {
    @Override
    default HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    default Optional<Object> getRequestBody() {
        return Optional.empty();
    }
}
