package gbsio.esiclient.client.request.status;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.status.ServerStatus;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves the Eve game server status.
 */
final public class ServerStatusRequest implements GetRequest<ServerStatus> {
    @Override
    public String getURL() {
        return "/v1/status/";
    }

    @Override
    public TypeReference<ServerStatus> getExpectedType() {
        return new TypeReference<ServerStatus>() {
        };
    }
}
