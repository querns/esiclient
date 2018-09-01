package gbsio.esiclient.client.request.planetaryinteraction;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.CustomsOffice;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves a list of customs offices owned by a corporation.
 *
 * NOTE: Server will throw a 500 error if any of the customs offices owned by
 * the corporation are unconfigured.
 */
final public class CustomsOfficesRequest implements GetListRequest<CustomsOffice, ImmutableList<CustomsOffice>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character with
     *                    Director roles in said corporation
     */
    public CustomsOfficesRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/customs_offices/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<CustomsOffice>> getExpectedType() {
        return new TypeReference<ImmutableList<CustomsOffice>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
