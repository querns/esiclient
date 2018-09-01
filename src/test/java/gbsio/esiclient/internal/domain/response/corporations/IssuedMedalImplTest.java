package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Medal;
import gbsio.esiclient.api.domain.response.corporation.IssuedMedal;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class IssuedMedalImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<IssuedMedal> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/issuedMedals.json"),
            new TypeReference<ImmutableList<IssuedMedal>>() { }
        );

        assertEquals(1, list.size());
        IssuedMedal medal = list.get(0);

        assertEquals(67890, medal.getIssuerCharacterID());
        assertEquals(ZonedDateTime.parse("2017-10-10T14:00:00Z"), medal.getIssueDate());
        assertEquals(45678, medal.getRecipientCharacterID());
        assertEquals(123, medal.getMedalID());
        assertEquals("Awesome Reason", medal.getReason());
        assertEquals(Medal.PrivacyStatus.PRIVATE, medal.getPrivacyStatus());

    }
}