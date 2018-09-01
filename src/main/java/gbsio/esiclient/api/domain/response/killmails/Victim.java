package gbsio.esiclient.api.domain.response.killmails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.internal.domain.response.killmails.VictimImpl;

/**
 * Represents the victim described in a killmail.
 */
@JsonDeserialize(as = VictimImpl.class)
public interface Victim extends Participant {
    /**
     * Gets the damage taken by the victim during the attack.
     *
     * @return the damage amount
     */
    int getDamageTaken();

    /**
     * Gets the items fit to the ship at the time of destruction.
     *
     * @return 0 or more items
     */
    ImmutableList<Item> getItems();

    /**
     * Get the position in space where the victim was attacked.
     *
     * @return the position
     */
    Coordinates getPosition();
}
