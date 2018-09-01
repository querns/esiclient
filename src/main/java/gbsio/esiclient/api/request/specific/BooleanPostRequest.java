package gbsio.esiclient.api.request.specific;

import gbsio.esiclient.api.request.BooleanRequest;
import io.netty.handler.codec.http.HttpMethod;

import java.util.Optional;

/**
 * A POST request that has a simple success or failure state.
 */
public interface BooleanPostRequest extends BooleanRequest {
    @Override
    default HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    Optional<Object> getRequestBody();
}
