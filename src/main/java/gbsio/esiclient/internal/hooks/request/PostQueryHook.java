package gbsio.esiclient.internal.hooks.request;

import gbsio.esiclient.api.request.Request;
import org.asynchttpclient.RequestBuilder;

import java.util.List;

/**
 * Represents a routine to modify the outgoing HTTP request after the URL is
 * fully crafted (including query parameters.)
 */
public interface PostQueryHook {
    /**
     * Perform the modification of the hook, potentially modifying the builder.
     *
     * Objects using this hook SHOULD NOT use {@link RequestBuilder#addQueryParam(String, String)}
     * or {@link RequestBuilder#addQueryParams(List)}. If adding query parameters
     * is needed, use a {@link QueryBuildingHook}.
     *
     * Due to the way {@link RequestBuilder} works, you can freely build the
     * asynchttpclient request, if needed, without consequences.
     *
     * @param builder the builder for the asynchttpclient request
     * @param request the original client request
     */
    void process(RequestBuilder builder, final Request<?> request) throws Exception;
}
