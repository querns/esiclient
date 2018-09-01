package gbsio.esiclient.client.request.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.wallet.JournalEntry;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieve up to 30 days of a character's wallet journal.
 */
final public class CharacterWalletJournalRequest implements GetListRequest<JournalEntry, ImmutableList<JournalEntry>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public CharacterWalletJournalRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v4/characters/%d/wallet/journal/", characterID);
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
