package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.character.AgentResearch;

import java.time.ZonedDateTime;

public class AgentResearchImpl implements AgentResearch {
    private final int agentID;
    private final float pointsPerDay;
    private final float remainderPoints;
    private final int skillTypeID;
    private final ZonedDateTime startedAt;

    AgentResearchImpl(
        @JsonProperty(value = "agent_id", required = true)
        final int agentID,
        @JsonProperty(value = "points_per_day", required = true)
        final float pointsPerDay,
        @JsonProperty(value = "remainder_points", required = true)
        final float remainderPoints,
        @JsonProperty(value = "skill_type_id", required = true)
        final int skillTypeID,
        @JsonProperty(value = "started_at", required = true)
        final ZonedDateTime startedAt
    ) {
        this.agentID = agentID;
        this.pointsPerDay = pointsPerDay;
        this.remainderPoints = remainderPoints;
        this.skillTypeID = skillTypeID;
        this.startedAt = startedAt;
    }

    public int getAgentID() {
        return agentID;
    }

    public float getPointsPerDay() {
        return pointsPerDay;
    }

    public float getRemainderPoints() {
        return remainderPoints;
    }

    public int getSkillTypeID() {
        return skillTypeID;
    }

    public ZonedDateTime getStartedAt() {
        return startedAt;
    }
}
