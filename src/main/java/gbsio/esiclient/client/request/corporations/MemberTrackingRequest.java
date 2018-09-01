package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.MemberTrackingData;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves data about corporation members that assists in tracking their
 * activities.
 */
final public class MemberTrackingRequest implements GetListRequest<MemberTrackingData, ImmutableList<MemberTrackingData>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a director in said
     *                    corporation
     */
    public MemberTrackingRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        //noinspection SpellCheckingInspection
        return String.format("/v1/corporations/%d/membertracking/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<MemberTrackingData>> getExpectedType() {
        return new TypeReference<ImmutableList<MemberTrackingData>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
