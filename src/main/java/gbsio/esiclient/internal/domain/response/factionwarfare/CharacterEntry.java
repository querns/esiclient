package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.Leaderboard;

import java.util.Optional;

public class CharacterEntry implements Leaderboard.Entry {
    private final Leaderboard.Entry delegate;

    CharacterEntry(
        @JsonProperty("amount")
        Integer amount,
        @JsonProperty("character_id")
        Integer characterID
    ) {
        delegate = new EntryImpl(amount, characterID);
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
