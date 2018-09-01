package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.Leaderboard;

import java.util.Optional;

class CorporationEntry implements Leaderboard.Entry {
    private final Leaderboard.Entry delegate;

    CorporationEntry(
        @JsonProperty("amount")
        Integer amount,
        @JsonProperty("corporation_id")
        Integer entryID
    ) {
        delegate = new EntryImpl(amount, entryID);
    }

    @Override
    public Optional<Integer> getAmount() {
        return delegate.getAmount();
    }

    @Override
    public Optional<Integer> getEntryID() {
        return delegate.getEntryID();
    }
}
