package gbsio.esiclient.internal.client.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.ListRequest;
import gbsio.esiclient.api.request.Request;
import io.netty.handler.codec.http.HttpMethod;

import java.util.Map;
import java.util.Optional;

class PaginatedRequest<U, T extends ImmutableList<U>> implements Request<T> {
    private final ListRequest<U, T> delegate;
    private final Map<String, Object> queryParameters;

    @SuppressWarnings({"unused"})
    PaginatedRequest(final ListRequest<U, T> delegate) {
        this(delegate, null);
    }

    @SuppressWarnings({"unused"})
    PaginatedRequest(final ListRequest<U, T> delegate, final Integer page) {
        this.delegate = delegate;

        if (null != page) {
            ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
            builder.putAll(delegate.getQueryParameters());
            builder.put("page", page);

            queryParameters = builder.build();
        } else {
            queryParameters = delegate.getQueryParameters();
        }
    }

    @Override
    public HttpMethod getHttpMethod() {
        return delegate.getHttpMethod();
    }

    @Override
    public Optional<Object> getRequestBody() {
        return delegate.getRequestBody();
    }

    @Override
    public TypeReference<T> getExpectedType() {
        return delegate.getExpectedType();
    }

    @Override
    public String getURL() {
        return delegate.getURL();
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return queryParameters;
    }

    @Override
    public Optional<String> getAccessToken() {
        return delegate.getAccessToken();
    }
}
