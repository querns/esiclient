package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.ContainerAuditLog;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves log entries from interactions with Audit Log Secure Containers.
 */
final public class ContainerAuditLogsRequest implements GetListRequest<ContainerAuditLog, ImmutableList<ContainerAuditLog>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token of a character with full
     *                    director roles for said corporation
     */
    public ContainerAuditLogsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/corporations/%d/containers/logs/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<ContainerAuditLog>> getExpectedType() {
        return new TypeReference<ImmutableList<ContainerAuditLog>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
