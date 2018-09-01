package gbsio.esiclient.api.domain.response.wars;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.wars.PrimaryPartyImpl;

/**
 * Represents the aggressor or defender in a war.
 */
@JsonDeserialize(as = PrimaryPartyImpl.class)
public interface PrimaryParty extends Party {
    /**
     * Gets the amount of ISK that has been destroyed by the party.
     *
     * @return the ISK destroyed
     */
    float getISKDestroyed();

    /**
     * Gets the number of ships killed by the party.
     *
     * @return the ship kill count
     */
    int getShipKillCount();
}
