package gbsio.esiclient.client.request.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Range;
import gbsio.esiclient.api.domain.response.wallet.Transaction;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Retrieves a corporation's wallet transactions.
 */
final public class CorporationWalletTransactionRequest implements GetRequest<ImmutableList<Transaction>> {
    private final int corporationID;
    private final String accessToken;
    private final Long fromID;
    private final int division;

    /**
     * Creates a request to retrieve older wallet transactions.
     *
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    corporation with Accountant, Junior Accountant, or
     *                    Director roles
     * @param division the division to query
     * @param fromTransactionID only return entries older than this transaction
     *                         ID
     * @throws IllegalArgumentException if division is not between 1 and 7
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public CorporationWalletTransactionRequest(final int corporationID, final String accessToken, final int division, final Long fromTransactionID) {
        Preconditions.checkArgument(
            Range.closed(1, 7).contains(division),
            "Division must be between 1 and 7"
        );
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.division = division;
        this.fromID = fromTransactionID;
    }

    /**
     * Creates a request to retrieve the most recent wallet transactions.
     *
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    corporation with Accountant, Junior Accountant, or
     *                    Director roles
     * @param division the division to query
     * @throws IllegalArgumentException if division is not between 1 and 7
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public CorporationWalletTransactionRequest(final int corporationID, final String accessToken, final int division) {
        this(corporationID, accessToken, division, null);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/wallets/%d/transactions/", corporationID, division);
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
