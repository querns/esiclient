package gbsio.esiclient.api.domain.response.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.character.AgentResearchImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;

/**
 * Represents information about research agents employed by the character.
 */
@JsonDeserialize(as = AgentResearchImpl.class)
public interface AgentResearch {
    /**
     * Get the unique ID for this agent.
     * @return the ID
     */
    int getAgentID();

    /**
     * Get the type ID for the skill which is being researched.
     *
     * This is an item type ID.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getSkillTypeID();

    /**
     * Get the date research was started.
     *
     * @return the start date
     */
    ZonedDateTime getStartedAt();

    /**
     * Get the rate at which Research Points are generated
     *
     * @return the rate
     */
    float getPointsPerDay();

    /**
     * Get the number of Research Points (RP) the character had the last time
     * they withdrew points.
     *
     * This is used to calculate the character's current RP.
     *
     * @return the remainder points
     */
    float getRemainderPoints();

    /**
     * Get the character's current research points with this NPC.
     *
     * @return the character's current research points.
     */
    default float getCurrentResearchPoints() {
        Period period = Period.between(this.getStartedAt().toLocalDate(), LocalDate.now());
        return this.getRemainderPoints() + (this.getPointsPerDay() * period.getDays());
    }
}
