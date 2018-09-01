package gbsio.esiclient.internal.response.impl.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.errors.GatewayTimeoutError;

public class GatewayTimeoutErrorImpl implements GatewayTimeoutError {
    private final int timeout;
    private final String errorMessage;

    public GatewayTimeoutErrorImpl(
        @JsonProperty("timeout") int timeout,
        @JsonProperty("error") String errorMessage) {
        this.timeout = timeout;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getTimeout() {
        return timeout;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
