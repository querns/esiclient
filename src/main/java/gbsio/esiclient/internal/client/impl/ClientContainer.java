package gbsio.esiclient.internal.client.impl;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import gbsio.esiclient.api.BaseClient;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.request.BooleanRequest;
import gbsio.esiclient.api.request.ListRequest;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;

import java.util.concurrent.CompletableFuture;

@Singleton
final public class ClientContainer implements Client {
    private final BaseClient normalClient;
    private final BaseClient lowPriorityClient;

    @Inject
    ClientContainer(
        @Named("Normal") BaseClient normalClient,
        @Named("Low Priority") BaseClient lowPriorityClient
    ) {
        this.normalClient = normalClient;
        this.lowPriorityClient = lowPriorityClient;
    }

    @Override
    public <T> CompletableFuture<Response<T>> sendRequest(final Request<T> request) {
        return normalClient.sendRequest(request);
    }

    @Override
    public <U, T extends ImmutableList<U>> CompletableFuture<Response<ImmutableList<U>>> sendRequest(final ListRequest<U, T> request) {
        return normalClient.sendRequest(request);
    }

    @Override
    public CompletableFuture<BooleanResponse> sendRequest(final BooleanRequest request) {
        return normalClient.sendRequest(request);
    }

    @Override
    public BaseClient withLowPriority() {
        return lowPriorityClient;
    }

}
