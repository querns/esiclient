package gbsio.esiclient.api.domain.response.skills;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.skills.SkillQueueEntryImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents an entry in a skill queue.
 */
@JsonDeserialize(as = SkillQueueEntryImpl.class)
public interface SkillQueueEntry {
    /**
     * Retrieves the level that the skill will be when it's finished training.
     *
     * @return An integer between 0 and 5.
     */
    int getFinishedLevel();

    /**
     * Retrieves the ID of the currently training skill. This ID is actually an
     * item type ID, and can be used to discover more information about the
     * skill.
     *
     * @return A positive integer
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getSkillID();

    /**
     * Retrieves the queue entry's position in the training queue.
     *
     * @return A positive integer
     */
    int getQueuePosition();

    /**
     * Retrieves the date this entry started or will start training.
     *
     * @return A date
     */
    Optional<ZonedDateTime> getStartDate();

    /**
     * Retrieves the date this entry will complete training.
     *
     * @return A date
     */
    Optional<ZonedDateTime> getFinishDate();

    /**
     * Retrieves the amount of skill points that this skill had when it started
     * or that it will have when it starts training.
     * <p>
     * This is used to assist in calculating the progress of the currently
     * training skill.
     *
     * @return A positive integer
     */
    Optional<Integer> getLevelStartSP();

    /**
     * Retrieves the SP total that the skill will have when it finishes training.
     *
     * @return the SP total
     */
    Optional<Integer> getLevelEndSP();

    /**
     * Returns the training start SP.
     *
     * @return the start SP
     */
    Optional<Integer> getTrainingStartSP();
}
