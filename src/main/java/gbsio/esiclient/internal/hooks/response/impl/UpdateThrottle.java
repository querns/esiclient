package gbsio.esiclient.internal.hooks.response.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.internal.hooks.response.HeadersHook;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.scheduling.ErrorCapacity;
import gbsio.esiclient.internal.scheduling.Throttle;
import org.asynchttpclient.HttpResponseHeaders;

/**
 * Updates the throttle.
 */
@Singleton
final public class UpdateThrottle implements HeadersHook {
    private final Throttle throttle;

    @Inject
    UpdateThrottle(Throttle throttle) {
        this.throttle = throttle;
    }

    @Override
    public void process(HttpResponseHeaders headers, RawContentResponse.Builder builder) {
        ErrorCapacity.from(headers.getHeaders()).ifPresent(throttle::updateErrorCapacity);
    }
}
