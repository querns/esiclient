package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.IssuedMedal;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves medals issued by a corporation.
 */
final public class IssuedMedalsRequest implements GetListRequest<IssuedMedal, ImmutableList<IssuedMedal>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a director in said
     *                    corporation
     */
    public IssuedMedalsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/medals/issued/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<IssuedMedal>> getExpectedType() {
        return new TypeReference<ImmutableList<IssuedMedal>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
