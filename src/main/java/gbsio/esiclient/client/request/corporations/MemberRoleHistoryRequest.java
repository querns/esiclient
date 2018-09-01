package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.RoleHistoryEntry;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves up to a month's worth of changes to roles assigned to members of
 * the corporation.
 */
final public class MemberRoleHistoryRequest implements GetListRequest<RoleHistoryEntry, ImmutableList<RoleHistoryEntry>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a director in said
     *                    corporation
     */
    public MemberRoleHistoryRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/roles/history/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<RoleHistoryEntry>> getExpectedType() {
        return new TypeReference<ImmutableList<RoleHistoryEntry>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
