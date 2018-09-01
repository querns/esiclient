package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.api.domain.response.corporation.RoleHistoryEntry;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RoleHistoryEntryImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<RoleHistoryEntry> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/roleHistoryEntry.json"),
            new TypeReference<ImmutableList<RoleHistoryEntry>>() { }
        );

        assertEquals(1, list.size());
        RoleHistoryEntry entry = list.get(0);

        assertEquals(ZonedDateTime.parse("2016-10-25T14:46:00Z"), entry.getChangeDate());
        assertEquals(12345, entry.getCharacterID());
        assertEquals(45678, entry.getIssuerID());
        assertEquals(1, entry.getNewRoles().size());
        assertTrue(entry.getNewRoles().contains(RoleType.STATION_MANAGER));
        assertEquals(1, entry.getOldRoles().size());
        assertTrue(entry.getOldRoles().contains(RoleType.DIPLOMAT));
        assertEquals(RoleHistoryEntry.RoleScope.ROLES, entry.getRoleScope());
    }
}