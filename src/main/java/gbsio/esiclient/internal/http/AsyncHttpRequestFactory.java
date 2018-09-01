package gbsio.esiclient.internal.http;

import gbsio.esiclient.api.request.Request;

/**
 * Builds an AsyncHTTPClient request from the client flavor Request.
 */
public interface AsyncHttpRequestFactory {
    org.asynchttpclient.Request createAsyncHttpRequest(final Request<?> request) throws Exception;
}
