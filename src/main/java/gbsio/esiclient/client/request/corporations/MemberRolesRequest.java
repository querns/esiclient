package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.MemberRoles;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves roles assigned by a corporation to its members.
 */
final public class MemberRolesRequest implements GetRequest<ImmutableList<MemberRoles>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character with
     *                    the Personnel Manager role or belonging to a character
     *                    possessing any grantable role
     */
    public MemberRolesRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/roles/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<MemberRoles>> getExpectedType() {
        return new TypeReference<ImmutableList<MemberRoles>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
