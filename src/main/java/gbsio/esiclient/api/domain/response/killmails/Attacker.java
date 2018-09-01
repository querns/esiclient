package gbsio.esiclient.api.domain.response.killmails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.killmails.AttackerImpl;

import java.util.Optional;

/**
 * Represents an attacker on a killmail.
 */
@JsonDeserialize(as = AttackerImpl.class)
public interface Attacker extends Participant {

    /**
     * Gets the damage dealt by this attacker.
     *
     * @return the damage amount
     */
    int getDamageDone();

    /**
     * Gets whether or not this attacker dealt the final blow.
     *
     * @return true if the attacker dealt the final blow
     */
    boolean dealtFinalBlow();

    /**
     * Gets the security status of the attacker.
     *
     * @return the security status
     */
    float getSecurityStatus();

    /**
     * Gets the item type ID of the weaponry used by the attacker at the time of
     * the attack.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the weapon's item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    Optional<Integer> getWeaponItemTypeID();
}
