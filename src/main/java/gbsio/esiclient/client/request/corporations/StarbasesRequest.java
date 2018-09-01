package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.Starbase;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Pulls a list of deployed starbases belonging to a corporation.
 */
final public class StarbasesRequest implements GetListRequest<Starbase, ImmutableList<Starbase>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a director in said
     *                    corporation
     */
    public StarbasesRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/starbases/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<Starbase>> getExpectedType() {
        return new TypeReference<ImmutableList<Starbase>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
