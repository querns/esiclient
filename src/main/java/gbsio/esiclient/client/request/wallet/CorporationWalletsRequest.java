package gbsio.esiclient.client.request.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.wallet.CorporationWallet;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves the wallet balance of each wallet division of a corporation.
 */
final public class CorporationWalletsRequest implements GetRequest<ImmutableList<CorporationWallet>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    corporation with Accountant, Junior Accountant, or
     *                    Director roles
     */
    public CorporationWalletsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/wallets/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<CorporationWallet>> getExpectedType() {
        return new TypeReference<ImmutableList<CorporationWallet>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
