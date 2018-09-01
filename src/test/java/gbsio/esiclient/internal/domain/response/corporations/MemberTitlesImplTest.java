package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.MemberTitles;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MemberTitlesImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<MemberTitles> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/memberTitles.json"),
            new TypeReference<ImmutableList<MemberTitles>>() { }
        );

        assertEquals(1, list.size());
        MemberTitles titles = list.get(0);

        assertEquals(12345, titles.getCharacterID());
        assertEquals(0, titles.getTitleIDs().size());
    }
}