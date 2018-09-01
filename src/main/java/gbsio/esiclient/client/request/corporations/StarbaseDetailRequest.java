package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.corporation.StarbaseDetail;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Pulls details about a single deployed starbase belonging to a corporation.
 */
final public class StarbaseDetailRequest implements GetRequest<StarbaseDetail> {
    private final int corporationID;
    private final String accessToken;
    private final int starbaseID;
    private final int solarSystemID;

    /**
     * @param corporationID the ID of the corporation that owns the starbase
     * @param accessToken an OAuth2 access token belonging to a director in said
     *                    corporation
     * @param starbaseID the ID of the starbase to query
     * @param solarSystemID the ID of the solar system where the starbase
     *                     resides
     */
    public StarbaseDetailRequest(final int corporationID, final String accessToken, final int starbaseID, final int solarSystemID) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.starbaseID = starbaseID;
        this.solarSystemID = solarSystemID;
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of("system_id", solarSystemID);
    }

    @Override
    public TypeReference<StarbaseDetail> getExpectedType() {
        return new TypeReference<StarbaseDetail>() {
        };
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/starbases/%d/", corporationID, starbaseID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
