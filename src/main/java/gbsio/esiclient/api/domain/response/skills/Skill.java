package gbsio.esiclient.api.domain.response.skills;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.skills.SkillImpl;

/**
 * Represents a skill trained by the character.
 */
@JsonDeserialize(as = SkillImpl.class)
public interface Skill {
    /**
     * Gets the active level of this skill.
     *
     * This differs from {@link #getTrainedSkillLevel()} when an account lapses
     * to Alpha status; Alpha restrictions can restrict how much of a skill is
     * able to be used.
     *
     * @return the active skill level
     */
    int getActiveSkillLevel();

    /**
     * Gets the item type ID for this skill.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the skill's item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getSkillItemTypeID();

    /**
     * Gets the number of skill points trained for this skill.
     *
     * @return the accrued skill points
     */
    long getAccruedSkillPoints();

    /**
     * Gets the level of the skill regardless of Alpha or Omega account status.
     *
     * @return the true skill level
     */
    int getTrainedSkillLevel();
}
