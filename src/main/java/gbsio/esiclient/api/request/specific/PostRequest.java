package gbsio.esiclient.api.request.specific;

import gbsio.esiclient.api.request.Request;
import io.netty.handler.codec.http.HttpMethod;

/**
 * Represents a request using HTTP method "POST".
 * @param <T> the expected return type
 */
public interface PostRequest<T> extends Request<T> {
    @Override
    default HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
