package gbsio.esiclient.client.request.loyalty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.loyalty.LoyaltyPointRecord;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves data on the loyalty points accrued by a character.
 */
final public class LoyaltyPointsRequest implements GetRequest<ImmutableList<LoyaltyPointRecord>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public LoyaltyPointsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/loyalty/points/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<LoyaltyPointRecord>> getExpectedType() {
        return new TypeReference<ImmutableList<LoyaltyPointRecord>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
