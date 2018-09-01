package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.api.domain.response.corporation.MemberRoles;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MemberRolesImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<MemberRoles> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/memberRoles.json"),
            new TypeReference<ImmutableList<MemberRoles>>() { }
        );

        assertEquals(1, list.size());
        MemberRoles roles = list.get(0);

        assertEquals(1000171, roles.getCharacterID());
        assertEquals(0, roles.getGrantableRoles().size());
        assertEquals(0, roles.getGrantableRolesAtHQ().size());
        assertEquals(0, roles.getGrantableRolesAtBase().size());
        assertEquals(0, roles.getGrantableRolesAtOther().size());
        assertEquals(0, roles.getRolesAtBase().size());
        assertEquals(0, roles.getRolesAtHQ().size());
        assertEquals(0, roles.getRolesAtOther().size());

        assertEquals(2, roles.getRoles().size());
        assertTrue(roles.getRoles().contains(RoleType.DIRECTOR));
        assertTrue(roles.getRoles().contains(RoleType.STATION_MANAGER));
    }
}