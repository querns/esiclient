package gbsio.esiclient.api.domain.response.skills;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.skills.TrainedSkillInfoImpl;

import java.util.Optional;

/**
 * Represents information about the character's trained skills.
 */
@JsonDeserialize(as = TrainedSkillInfoImpl.class)
public interface TrainedSkillInfo {
    /**
     * Gets the skills trained by the character.
     *
     * @return 1 or more skills
     */
    ImmutableList<Skill> getSkills();

    /**
     * Get the total number of skill points earned by the character.
     *
     * @return the skill point total
     */
    long getTotalSkillPoints();

    /**
     * Gets the amount of unallocated skill points accrued by the character.
     *
     * @return the unallocated skill point total
     */
    Optional<Integer> getUnallocatedSkillPoints();
}
