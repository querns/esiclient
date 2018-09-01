package gbsio.esiclient.internal.client.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.request.BooleanRequest;
import gbsio.esiclient.api.request.Request;
import io.netty.handler.codec.http.HttpMethod;

import java.util.Map;
import java.util.Optional;

class DelegatedBooleanRequest implements Request<Void> {
    private final BooleanRequest delegate;

    DelegatedBooleanRequest(final BooleanRequest delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getURL() {
        return delegate.getURL();
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return delegate.getQueryParameters();
    }

    @Override
    public Optional<String> getAccessToken() {
        return delegate.getAccessToken();
    }

    @Override
    public Optional<Object> getRequestBody() {
        return delegate.getRequestBody();
    }

    @Override
    public TypeReference<Void> getExpectedType() {
        return new TypeReference<Void>() {
        };
    }

    @Override
    public HttpMethod getHttpMethod() {
        return delegate.getHttpMethod();
    }
}
