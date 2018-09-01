package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Blueprint;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves information about blueprints belonging to the corporation.
 */
final public class CorporationBlueprintsRequest implements GetListRequest<Blueprint, ImmutableList<Blueprint>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character with
     *                    director roles in said corporation
     */
    public CorporationBlueprintsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/corporations/%d/blueprints/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<Blueprint>> getExpectedType() {
        return new TypeReference<ImmutableList<Blueprint>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
