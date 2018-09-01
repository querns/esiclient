package gbsio.esiclient.internal.response.impl.errors;

import gbsio.esiclient.api.domain.response.errors.Error;

public class ClientError implements Error {
    private final String errorMessage;

    public ClientError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

}
