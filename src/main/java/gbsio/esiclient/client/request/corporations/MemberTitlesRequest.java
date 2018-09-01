package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.MemberTitles;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves a list of members that possess titles granted by a corporation and
 * the titles they possess.
 */
final public class MemberTitlesRequest implements GetRequest<ImmutableList<MemberTitles>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a director in said
     *                    corporation
     */
    public MemberTitlesRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/members/titles/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<MemberTitles>> getExpectedType() {
        return new TypeReference<ImmutableList<MemberTitles>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
