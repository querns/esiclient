package gbsio.esiclient.internal.domain.response.skills;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.skills.SkillQueueEntry;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SkillQueueEntryImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<SkillQueueEntry> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/skills/skillQueue.json"),
            new TypeReference<ImmutableList<SkillQueueEntry>>() { }
        );

        assertEquals(3, list.size());
        SkillQueueEntry one = list.get(0);
        SkillQueueEntry two = list.get(1);
        SkillQueueEntry three = list.get(2);

        assertTrue(one.getFinishDate().isPresent());
        assertEquals(ZonedDateTime.parse("2016-06-29T10:47:00Z"), one.getFinishDate().get());
        assertEquals(3, one.getFinishedLevel());
        assertEquals(0, one.getQueuePosition());
        assertEquals(1, one.getSkillID());
        assertTrue(one.getStartDate().isPresent());
        assertEquals(ZonedDateTime.parse("2016-06-29T10:46:00Z"), one.getStartDate().get());

        assertTrue(two.getFinishDate().isPresent());
        assertEquals(ZonedDateTime.parse("2016-07-15T10:47:00Z"), two.getFinishDate().get());
        assertEquals(4, two.getFinishedLevel());
        assertEquals(1, two.getQueuePosition());
        assertEquals(1, two.getSkillID());
        assertTrue(two.getStartDate().isPresent());
        assertEquals(ZonedDateTime.parse("2016-06-29T10:47:00Z"), two.getStartDate().get());

        assertTrue(three.getFinishDate().isPresent());
        assertEquals(ZonedDateTime.parse("2016-08-30T10:47:00Z"), three.getFinishDate().get());
        assertEquals(2, three.getFinishedLevel());
        assertEquals(2, three.getQueuePosition());
        assertEquals(2, three.getSkillID());
        assertTrue(three.getStartDate().isPresent());
        assertEquals(ZonedDateTime.parse("2016-07-15T10:47:00Z"), three.getStartDate().get());
    }
}