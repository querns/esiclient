package gbsio.esiclient.internal.response.impl.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.errors.ForbiddenError;

public class ForbiddenErrorImpl implements ForbiddenError {
    private final int ssoStatus;
    private final String errorMessage;

    public ForbiddenErrorImpl(
        @JsonProperty("sso_status")
        int ssoStatus,
        @JsonProperty("error")
        String errorMessage
    ) {
        this.ssoStatus = ssoStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getSsoStatus() {
        return ssoStatus;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
