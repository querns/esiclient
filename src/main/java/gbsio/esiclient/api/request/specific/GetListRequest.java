package gbsio.esiclient.api.request.specific;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.ListRequest;
import io.netty.handler.codec.http.HttpMethod;

/**
 * Represents a request made to ESI of HTTP method "GET", where pagination is
 * expected.
 *
 * The client will automatically detect the presence of pagination and cascade
 * calls to ESI to collect any additional pages needed to completely fulfill the
 * request.
 *
 * @param <U> the expected object contained in the list of response objects
 * @param <T> a list containing objects of type U
 */
public interface GetListRequest<U, T extends ImmutableList<U>> extends ListRequest<U, T> {
    default HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }
}
