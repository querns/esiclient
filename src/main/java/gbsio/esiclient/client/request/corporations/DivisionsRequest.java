package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.corporation.Divisions;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about the names of wallets and hangars belonging to a
 * corporation.
 */
final public class DivisionsRequest implements GetRequest<Divisions> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a director in said
     *                    corporation
     */
    public DivisionsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/divisions/", corporationID);
    }

    @Override
    public TypeReference<Divisions> getExpectedType() {
        return new TypeReference<Divisions>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
