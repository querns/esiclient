package gbsio.esiclient.api.domain.response.wars;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.wars.WarImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Describes a war between two corporations.
 */
@JsonDeserialize(as = WarImpl.class)
public interface War {
    /**
     * Gets the aggressor of the war.
     *
     * @return the aggressor
     */
    PrimaryParty getAggressor();

    /**
     * Gets the allies pledging to assist the defender in a war.
     *
     * @return 0 or more allies
     */
    ImmutableList<Party> getAllies();

    /**
     * War were declared on this date.
     *
     * @return the declaration date
     */
    ZonedDateTime getDeclarationDate();

    /**
     * Gets the defender in the war.
     *
     * @return the defender
     */
    PrimaryParty getDefender();

    /**
     * Gets the date the war was finished.
     *
     * @return the finish date
     */
    Optional<ZonedDateTime> getFinishDate();

    /**
     * Gets the unique ID for this war.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets whether or not the war is mutual.
     *
     * Mutual wars do not cost the aggressor ISK to keep alive.
     *
     * @return true if the war is mutual
     */
    boolean isMutual();

    /**
     * Gets whether or not the defender is accepting new allies in the war.
     *
     * @return true if the defender is accepting allies
     */
    boolean isAcceptingAllies();

    /**
     * Gets the date that the war was retracted.
     *
     * @return the retract date
     */
    Optional<ZonedDateTime> getRetractDate();

    /**
     * Gets the date the war started.
     *
     * @return the start date
     */
    Optional<ZonedDateTime> getStartDate();
}
