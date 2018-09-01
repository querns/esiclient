package gbsio.esiclient.internal.http.impl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;

final public class AsyncHttpClientProvider implements Provider<AsyncHttpClient> {
    private final AsyncHttpClient client;

    @Inject
    AsyncHttpClientProvider(@Named("User Agent") final String userAgent) {
        final DefaultAsyncHttpClientConfig.Builder builder = new DefaultAsyncHttpClientConfig.Builder();
        builder.setUserAgent(userAgent);

        client = new DefaultAsyncHttpClient(builder.build());
    }

    @Override
    public AsyncHttpClient get() {
        return client;
    }
}
