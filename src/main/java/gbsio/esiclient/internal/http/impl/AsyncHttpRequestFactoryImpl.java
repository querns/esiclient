package gbsio.esiclient.internal.http.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import gbsio.esiclient.internal.hooks.request.PostQueryHook;
import gbsio.esiclient.internal.hooks.request.QueryBuildingHook;
import gbsio.esiclient.internal.http.AsyncHttpRequestFactory;
import gbsio.esiclient.internal.http.QueryMapConverter;
import org.asynchttpclient.Request;
import org.asynchttpclient.RequestBuilder;

import java.util.Set;

@Singleton
public class AsyncHttpRequestFactoryImpl implements AsyncHttpRequestFactory {
    private final String esiServer;
    private final QueryMapConverter queryMapConverter;
    private final Set<PostQueryHook> postQueryHooks;
    private final Set<QueryBuildingHook> queryBuildingHooks;

    @Inject
    AsyncHttpRequestFactoryImpl(
        @Named("ESIServer") final String esiServer,
        final QueryMapConverter queryMapConverter,
        final Set<PostQueryHook> postQueryHooks, final Set<QueryBuildingHook> queryBuildingHooks
    ) {
        this.esiServer = esiServer;
        this.queryMapConverter = queryMapConverter;
        this.postQueryHooks = postQueryHooks;
        this.queryBuildingHooks = queryBuildingHooks;
    }

    @Override
    public Request createAsyncHttpRequest(final gbsio.esiclient.api.request.Request<?> request) throws Exception {
        final RequestBuilder builder = new RequestBuilder();

        builder.setMethod(request.getHttpMethod().name());
        builder.setUrl(esiServer.concat(request.getURL()));
        builder.setQueryParams(queryMapConverter.buildQueryMap(request.getQueryParameters()));

        for (QueryBuildingHook queryBuildingHook : queryBuildingHooks) {
            queryBuildingHook.process(builder, request);
        }

        for (PostQueryHook postQueryHook : postQueryHooks) {
            postQueryHook.process(builder, request);
        }

        return builder.build();
    }
}
