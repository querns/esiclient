package gbsio.esiclient.internal.domain.response.skills;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.skills.Skill;

public class SkillImpl implements Skill {
    private final int activeSkillLevel;
    private final int skillItemTypeID;
    private final long accruedSkillPoints;
    private final int trainedSkillLevel;

    SkillImpl(
        @JsonProperty(value = "active_skill_level", required = true)
        final int activeSkillLevel,
        @JsonProperty(value = "skill_id", required = true)
        final int skillItemTypeID,
        @SuppressWarnings("SpellCheckingInspection") @JsonProperty(value = "skillpoints_in_skill", required = true)
        final long accruedSkillPoints,
        @JsonProperty(value = "trained_skill_level", required = true)
        final int trainedSkillLevel
    ) {
        this.activeSkillLevel = activeSkillLevel;
        this.skillItemTypeID = skillItemTypeID;
        this.accruedSkillPoints = accruedSkillPoints;
        this.trainedSkillLevel = trainedSkillLevel;
    }

    @Override
    public int getActiveSkillLevel() {
        return activeSkillLevel;
    }

    @Override
    public int getSkillItemTypeID() {
        return skillItemTypeID;
    }

    @Override
    public long getAccruedSkillPoints() {
        return accruedSkillPoints;
    }

    @Override
    public int getTrainedSkillLevel() {
        return trainedSkillLevel;
    }
}
