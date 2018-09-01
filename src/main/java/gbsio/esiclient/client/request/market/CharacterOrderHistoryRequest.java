package gbsio.esiclient.client.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.CharacterOrder;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves cancelled and expired market orders for a character up to 90 days
 * in the past.
 */
final public class CharacterOrderHistoryRequest implements GetListRequest<CharacterOrder, ImmutableList<CharacterOrder>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public CharacterOrderHistoryRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/orders/history/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<CharacterOrder>> getExpectedType() {
        return new TypeReference<ImmutableList<CharacterOrder>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
