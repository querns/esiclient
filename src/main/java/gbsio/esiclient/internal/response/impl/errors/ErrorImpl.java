package gbsio.esiclient.internal.response.impl.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.errors.Error;

public class ErrorImpl implements Error {
    private final String errorMessage;

    @JsonCreator
    public ErrorImpl(@JsonProperty("error") String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

}
