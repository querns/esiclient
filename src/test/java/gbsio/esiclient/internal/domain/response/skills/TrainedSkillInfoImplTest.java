package gbsio.esiclient.internal.domain.response.skills;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.skills.Skill;
import gbsio.esiclient.api.domain.response.skills.TrainedSkillInfo;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TrainedSkillInfoImplTest {
    @Test
    void parse() throws IOException {
        TrainedSkillInfo info = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/skills/skills.json"),
            new TypeReference<TrainedSkillInfo>() { }
        );

        assertFalse(info.getUnallocatedSkillPoints().isPresent());
        assertEquals(20000L, info.getTotalSkillPoints());
        assertEquals(2, info.getSkills().size());

        Skill one = info.getSkills().get(0);
        Skill two = info.getSkills().get(1);

        assertEquals(3, one.getActiveSkillLevel());
        assertEquals(1, one.getSkillItemTypeID());
        assertEquals(10000L, one.getAccruedSkillPoints());
        assertEquals(4, one.getTrainedSkillLevel());

        assertEquals(1, two.getActiveSkillLevel());
        assertEquals(2, two.getSkillItemTypeID());
        assertEquals(10000L, two.getAccruedSkillPoints());
        assertEquals(1, two.getTrainedSkillLevel());
    }
}