package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.AgentResearch;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AgentResearchImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<AgentResearch> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/agentResearch.json"),
            new TypeReference<ImmutableList<AgentResearch>>() { }
        );

        assertEquals(1, list.size());
        AgentResearch research = list.get(0);

        assertEquals(3009358, research.getAgentID());
        assertEquals(53.5346f, research.getPointsPerDay(), 0.0001);
        assertEquals(53604.0634f, research.getRemainderPoints(), 0.0001);
        assertEquals(11450, research.getSkillTypeID());
        assertEquals(ZonedDateTime.parse("2017-03-23T14:47:00Z"), research.getStartedAt());
    }
}