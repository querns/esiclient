package gbsio.esiclient.internal.domain.response.killmails;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.killmails.KillmailIDHash;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class KillmailIDHashImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<KillmailIDHash> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/killmails/killmailIDHash.json"),
            new TypeReference<ImmutableList<KillmailIDHash>>() { }
        );

        assertEquals(2, list.size());
        KillmailIDHash one = list.get(0);
        KillmailIDHash two = list.get(1);

        assertEquals("8eef5e8fb6b88fe3407c489df33822b2e3b57a5e", one.getHash());
        assertEquals(2, one.getKillmailID());

        assertEquals("b41ccb498ece33d64019f64c0db392aa3aa701fb", two.getHash());
        assertEquals(1, two.getKillmailID());
    }
}