package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CharacterRoles;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRolesImplTest {
    @Test
    void parse() throws IOException {
        CharacterRoles roles = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/characterRoles.json"),
            new TypeReference<CharacterRoles>() { }
        );

        assertEquals(ImmutableList.of(), roles.getRolesAtBase());
        assertEquals(ImmutableList.of(), roles.getRolesAtHQ());
        assertEquals(ImmutableList.of(), roles.getRolesAtOther());

        assertEquals(2, roles.getRoles().size());
        assertEquals(RoleType.DIRECTOR, roles.getRoles().get(0));
        assertEquals(RoleType.STATION_MANAGER, roles.getRoles().get(1));
    }
}