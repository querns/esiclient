package gbsio.esiclient.internal.http.impl;

import com.google.inject.Inject;
import gbsio.esiclient.internal.hooks.response.HeadersHook;
import gbsio.esiclient.internal.hooks.response.StatusHook;
import gbsio.esiclient.internal.http.RawContentResponse;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.HttpResponseHeaders;
import org.asynchttpclient.HttpResponseStatus;

import java.util.Set;

/**
 * Handler for asynchronously handling a response from ESI.
 */
public class AsyncHandlerImpl implements AsyncHandler<RawContentResponse> {
    private final Set<HeadersHook> headersHooks;
    private final Set<StatusHook> statusHooks;

    private final RawContentResponse.Builder responseBuilder = RawContentResponse.builder();

    @Inject
    AsyncHandlerImpl(
        Set<HeadersHook> headersHooks,
        Set<StatusHook> statusHooks
    ) {
        this.headersHooks = headersHooks;
        this.statusHooks = statusHooks;
    }

    @Override
    public void onThrowable(Throwable throwable) {
    }

    @Override
    public State onBodyPartReceived(HttpResponseBodyPart httpResponseBodyPart) {
        responseBuilder.accumulate(httpResponseBodyPart);
        return State.CONTINUE;
    }

    @Override
    public State onStatusReceived(HttpResponseStatus httpResponseStatus) {
        responseBuilder.accumulate(httpResponseStatus);
        statusHooks.forEach(statusHook ->
            statusHook.process(httpResponseStatus.getStatusCode(), responseBuilder)
        );

        return State.CONTINUE;
    }

    @Override
    public State onHeadersReceived(HttpResponseHeaders httpResponseHeaders) {
        responseBuilder.accumulate(httpResponseHeaders);
        headersHooks.forEach(headersHook ->
            headersHook.process(httpResponseHeaders, responseBuilder)
        );

        return State.CONTINUE;
    }

    @Override
    public RawContentResponse onCompleted() {
        return responseBuilder.build();
    }
}
