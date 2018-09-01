package gbsio.esiclient.api.domain.response.killmails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.killmails.KillmailImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents a record of a ship being destroyed in combat.
 */
@JsonDeserialize(as = KillmailImpl.class)
public interface Killmail {
    /**
     * Get the attackers responsible for creating this killmail.
     *
     * @return the attackers
     */
    ImmutableList<Attacker> getAttackers();

    /**
     * Gets the unique ID for this killmail.
     *
     * @return the ID
     */
    int getID();

    /**
     * Get the date that the killmail occurred.
     *
     * @return the date
     */
    ZonedDateTime getDate();

    /**
     * Gets the ID of the moon where this killmail took place, if any.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the moon ID
     * @see gbsio.esiclient.api.domain.response.universe.Moon
     */
    Optional<Integer> getMoonID();

    /**
     * Get the victim of the killmail.
     *
     * @return the victim
     */
    Victim getVictim();

    /**
     * Gets the ID of the war this killmail was recorded for, if any.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the war ID
     * @see gbsio.esiclient.api.domain.response.wars.War
     */
    Optional<Integer> getWarID();

    /**
     * Gets the ID of the solar system where this killmail originated.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();
}
