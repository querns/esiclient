package gbsio.esiclient.api.domain.response.contacts;

import java.util.Optional;

/**
 * Represents a contact set by an entity which can employ the in-game watchlist
 * (characters and corporations.)
 */
@SuppressWarnings("SpellCheckingInspection")
public interface WatchlistableContact extends BaseContact {
    /**
     * Returns whether or not the contact for this character is on the
     * character's watchlist.
     *
     * @return true if the contact is watchlisted, false if it isn't, and
     * missing if the watchlist status is unknown
     */
    Optional<Boolean> isWatched();
}
