package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.Leaderboard;

import java.util.Optional;

public class FactionEntry implements Leaderboard.Entry {
    private final Leaderboard.Entry delegate;

    FactionEntry(
        @JsonProperty("amount")
        Integer amount,
        @JsonProperty("faction_id")
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
