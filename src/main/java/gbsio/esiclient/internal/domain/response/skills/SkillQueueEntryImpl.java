package gbsio.esiclient.internal.domain.response.skills;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.skills.SkillQueueEntry;

import java.time.ZonedDateTime;
import java.util.Optional;

public class SkillQueueEntryImpl implements SkillQueueEntry {
    private final int finishedLevel;
    private final int skillID;
    private final int queuePosition;
    private final ZonedDateTime startDate;
    private final ZonedDateTime finishDate;
    private final Integer levelStartSP;
    private final Integer levelEndSP;
    private final Integer trainingStartSP;

    SkillQueueEntryImpl(
        @JsonProperty(value = "finished_level", required = true)
        final int finishedLevel,
        @JsonProperty(value = "skill_id", required = true)
        final int skillID,
        @JsonProperty(value = "queue_position", required = true)
        final int queuePosition,
        @JsonProperty("start_date")
        final ZonedDateTime startDate,
        @JsonProperty("finish_date")
        final ZonedDateTime finishDate,
        @JsonProperty("level_start_sp")
        final Integer levelStartSP,
        @JsonProperty("level_end_sp")
        final Integer levelEndSP,
        @JsonProperty("training_start_sp")
        final Integer trainingStartSP
    ) {
        this.finishedLevel = finishedLevel;
        this.skillID = skillID;
        this.queuePosition = queuePosition;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.levelStartSP = levelStartSP;
        this.levelEndSP = levelEndSP;
        this.trainingStartSP = trainingStartSP;
    }

    @Override
    public int getFinishedLevel() {
        return finishedLevel;
    }

    @Override
    public int getSkillID() {
        return skillID;
    }

    @Override
    public int getQueuePosition() {
        return queuePosition;
    }

    @Override
    public Optional<ZonedDateTime> getStartDate() {
        return Optional.ofNullable(startDate);
    }

    @Override
    public Optional<ZonedDateTime> getFinishDate() {
        return Optional.ofNullable(finishDate);
    }

    @Override
    public Optional<Integer> getLevelStartSP() {
        return Optional.ofNullable(levelStartSP);
    }

    @Override
    public Optional<Integer> getLevelEndSP() {
        return Optional.ofNullable(levelEndSP);
    }

    @Override
    public Optional<Integer> getTrainingStartSP() {
        return Optional.ofNullable(trainingStartSP);
    }
}
