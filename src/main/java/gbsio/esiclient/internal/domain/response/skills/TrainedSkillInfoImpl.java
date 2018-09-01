package gbsio.esiclient.internal.domain.response.skills;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.skills.Skill;
import gbsio.esiclient.api.domain.response.skills.TrainedSkillInfo;

import java.util.Optional;

public class TrainedSkillInfoImpl implements TrainedSkillInfo {
    private final ImmutableList<Skill> skills;
    private final long totalSkillPoints;
    private final Integer unallocatedSkillPoints;

    TrainedSkillInfoImpl(
        @JsonProperty(value = "skills", required = true)
        final ImmutableList<Skill> skills,
        @JsonProperty(value = "total_sp", required = true)
        final long totalSkillPoints,
        @JsonProperty("unallocated_sp")
        final Integer unallocatedSkillPoints
    ) {
        this.skills = MoreObjects.firstNonNull(skills, ImmutableList.of());
        this.totalSkillPoints = totalSkillPoints;
        this.unallocatedSkillPoints = unallocatedSkillPoints;
    }

    @Override
    public ImmutableList<Skill> getSkills() {
        return skills;
    }

    @Override
    public long getTotalSkillPoints() {
        return totalSkillPoints;
    }

    @Override
    public Optional<Integer> getUnallocatedSkillPoints() {
        return Optional.ofNullable(unallocatedSkillPoints);
    }
}
