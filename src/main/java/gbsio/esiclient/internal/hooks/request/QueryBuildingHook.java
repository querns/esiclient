package gbsio.esiclient.internal.hooks.request;

import gbsio.esiclient.api.request.Request;
import org.asynchttpclient.RequestBuilder;

/**
 * Represents a routine to modify the query being constructed by the client.
 */
public interface QueryBuildingHook {
    /**
     * Perform the modification of the hook, potentially modifying the builder.
     *
     * Due to the way {@link RequestBuilder} works, you can freely build the
     * asynchttpclient request, if needed, without consequences.
     *
     * @param builder the builder for the asynchttpclient request
     * @param request the original client request
     */
    void process(RequestBuilder builder, Request<?> request);
}
