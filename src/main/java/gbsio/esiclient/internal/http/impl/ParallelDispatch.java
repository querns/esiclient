package gbsio.esiclient.internal.http.impl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.internal.http.*;
import gbsio.esiclient.internal.scheduling.Throttle;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.ListenableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@Singleton
public class ParallelDispatch implements Dispatch {
    private final AsyncHttpClient httpClient;
    private final Provider<AsyncHandler<RawContentResponse>> asyncHandlerProvider;
    private final AsyncHttpRequestFactory requestFactory;
    private final Throttle throttle;
    private final ETagProcessor eTagProcessor;
    private final Executor executor;

    @Inject
    ParallelDispatch(
        final AsyncHttpClient httpClient,
        final Provider<AsyncHandler<RawContentResponse>> asyncHandlerProvider,
        final AsyncHttpRequestFactory requestFactory,
        final Throttle throttle,
        final ETagProcessor eTagProcessor,
        final Executor executor
    ) {
        this.httpClient = httpClient;
        this.asyncHandlerProvider = asyncHandlerProvider;
        this.requestFactory = requestFactory;
        this.throttle = throttle;
        this.eTagProcessor = eTagProcessor;
        this.executor = executor;
    }

    @Override
    public CompletableFuture<RawContentResponse> executeSingleRequest(final Request<?> request) {
        final CompletableFuture<RawContentResponse> future = new CompletableFuture<>();

        executor.execute(() -> {
            // Used to release the throttle's permit if we complete
            // exceptionally before it happens normally, so we don't permanently
            // bind up one of the permits.
            final AtomicBoolean throttleAcquired = new AtomicBoolean(false);

            try {
                final org.asynchttpclient.Request asyncHttpRequest = requestFactory.createAsyncHttpRequest(request);

                throttle.acquire();
                throttleAcquired.set(true);

                final ListenableFuture<RawContentResponse> responseFuture = httpClient.executeRequest(
                    asyncHttpRequest, asyncHandlerProvider.get()
                ).addListener(() -> {
                    throttle.release();
                    throttleAcquired.set(false);
                }, executor);

                final RawContentResponse response = eTagProcessor.processETags(
                    responseFuture.get(),
                    asyncHttpRequest.getUrl()
                );

                future.complete(response);
            } catch (Exception e) {
                future.completeExceptionally(e);
                if (throttleAcquired.get()) {
                    throttle.release();
                }
            }
        });

        return future;
    }

}