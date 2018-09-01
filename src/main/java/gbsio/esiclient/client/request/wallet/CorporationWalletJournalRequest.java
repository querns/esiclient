package gbsio.esiclient.client.request.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import gbsio.esiclient.api.domain.response.wallet.JournalEntry;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves the last 30 days of a corporation's wallet journal.
 */
final public class CorporationWalletJournalRequest implements GetListRequest<JournalEntry, ImmutableList<JournalEntry>> {
    private final int corporationID;
    private final String accessToken;
    private final int division;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a character in the
     *                    corporation with Accountant, Junior Accountant, or
     *                    Director roles
     * @param division a number from 1 to 7 denoting which division's entries to
     *                 query
     * @throws IllegalArgumentException if division isn't between 1 and 7
     */
    public CorporationWalletJournalRequest(final int corporationID, final String accessToken, final int division) {
        Preconditions.checkArgument(
            Range.closed(1, 7).contains(division),
            "Division must be between 1 and 7 inclusive"
        );
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.division = division;
    }

    @Override
    public String getURL() {
        return String.format("/v3/corporations/%d/wallets/%d/journal/", corporationID, division);
    }

    @Override
    public TypeReference<ImmutableList<JournalEntry>> getExpectedType() {
        return new TypeReference<ImmutableList<JournalEntry>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
