package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves the corporation's member count limit, as determined by the skills
 * of the CEO of the corporation.
 */
final public class MemberLimitRequest implements GetRequest<Integer> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a director in said
     *                    corporation
     */
    public MemberLimitRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/members/limit/", corporationID);
    }

    @Override
    public TypeReference<Integer> getExpectedType() {
        return new TypeReference<Integer>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
