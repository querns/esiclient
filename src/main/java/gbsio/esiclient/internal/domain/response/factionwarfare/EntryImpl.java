package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.Leaderboard;

import java.util.Optional;

public class EntryImpl implements Leaderboard.Entry {
    private final Integer amount;
    private final Integer entryID;

    EntryImpl(
        @JsonProperty("amount")
        final Integer amount,
        @JsonAlias({"faction_id", "character_id", "corporation_id"})
        final Integer entryID
    ) {
        this.amount = amount;
        this.entryID = entryID;
    }

    @Override
    public Optional<Integer> getAmount() {
        return Optional.ofNullable(amount);
    }

    @Override
    public Optional<Integer> getEntryID() {
        return Optional.ofNullable(entryID);
    }
}
