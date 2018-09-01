package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.CorporationMedal;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves the medals issued by a corporation.
 */
final public class CorporationMedalsRequest implements GetListRequest<CorporationMedal, ImmutableList<CorporationMedal>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token of a character in said
     *                    corporation
     */
    public CorporationMedalsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/medals/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<CorporationMedal>> getExpectedType() {
        return new TypeReference<ImmutableList<CorporationMedal>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
