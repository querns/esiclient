package gbsio.esiclient.client.request.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.wallet.Transaction;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Retrieves a character's wallet transactions.
 */
final public class CharacterWalletTransactionsRequest implements GetRequest<ImmutableList<Transaction>> {
    private final int characterID;
    private final String accessToken;
    private final Long fromID;

    /**
     * Creates a request to retrieve older wallet transactions.
     *
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param fromTransactionID only returns entries older than this transaction
     *                          ID
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public CharacterWalletTransactionsRequest(final int characterID, final String accessToken, final Long fromTransactionID) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.fromID = fromTransactionID;
    }

    /**
     * Creates a request to retrieve the most recent wallet transactions.
     *
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public CharacterWalletTransactionsRequest(final int characterID, final String accessToken) {
        this(characterID, accessToken, null);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/wallet/transactions/", characterID);
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        if (null != fromID) {
            return ImmutableMap.of("from_id", fromID);
        }

        return ImmutableMap.of();
    }

    @Override
    public TypeReference<ImmutableList<Transaction>> getExpectedType() {
        return new TypeReference<ImmutableList<Transaction>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
