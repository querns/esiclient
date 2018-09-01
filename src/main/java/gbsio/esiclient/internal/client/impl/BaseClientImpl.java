package gbsio.esiclient.internal.client.impl;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import gbsio.esiclient.api.BaseClient;
import gbsio.esiclient.api.request.BooleanRequest;
import gbsio.esiclient.api.request.ListRequest;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.internal.http.Dispatch;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.response.ResponseProcessor;
import gbsio.esiclient.internal.util.ImmutableListCollector;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseClientImpl implements BaseClient {
    private final Dispatch http;
    private final ResponseProcessor processor;
    private final Executor executor;

    @Inject
    BaseClientImpl(final Dispatch dispatch, final ResponseProcessor processor, final Executor executor) {
        this.http = dispatch;
        this.processor = processor;
        this.executor = executor;
    }

    @Override
    public <T> CompletableFuture<Response<T>> sendRequest(final Request<T> request) {
        return http.executeSingleRequest(request)
            .thenApplyAsync(response -> processor.deserializeResponse(response, request.getExpectedType()), executor);
    }

    @Override
    public <U, T extends ImmutableList<U>> CompletableFuture<Response<ImmutableList<U>>> sendRequest(final ListRequest<U, T> request) {
        return http.executeSingleRequest(new PaginatedRequest<>(request))
            .thenApplyAsync(response -> processor.deserializeAndFlatten(fanOutPages(request, response), request), executor);
    }

    @Override
    public CompletableFuture<BooleanResponse> sendRequest(final BooleanRequest request) {
        return http.executeSingleRequest(new DelegatedBooleanRequest(request))
            .thenApplyAsync(processor::deserializeResponse, executor);
    }

    private <U, T extends ImmutableList<U>> ImmutableList<RawContentResponse> fanOutPages(
        final ListRequest<U, T> request,
        final RawContentResponse pageOneResponse
    ) {
        final int pageCount = pageOneResponse.getPageCount().orElse(1);
        if (pageCount < 2) {
            return ImmutableList.of(pageOneResponse);
        }

        // We have to set up two stream pipelines here, or the requests won't
        // happen in parallel.
        final List<CompletableFuture<RawContentResponse>> futuresList = IntStream.rangeClosed(2, pageCount)
            .mapToObj(page -> new PaginatedRequest<>(request, page))
            .map(http::executeSingleRequest)
            .collect(Collectors.toList());

        return Stream.concat(
            Stream.of(pageOneResponse),
            futuresList.stream().map(CompletableFuture::join)
        ).collect(new ImmutableListCollector<>());
    }

}
