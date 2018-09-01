package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.api.domain.response.corporation.CorporationTitle;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationTitleImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<CorporationTitle> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/corporationTitles.json"),
            new TypeReference<ImmutableList<CorporationTitle>>() { }
        );

        assertEquals(1, list.size());
        CorporationTitle title = list.get(0);

        assertTrue(title.getName().isPresent());
        assertTrue(title.getID().isPresent());

        assertEquals("Awesome Title", title.getName().get());
        assertEquals((Integer)1, title.getID().get());

        assertTrue(title.getRolesAtBase().isEmpty());
        assertTrue(title.getRolesAtHQ().isEmpty());
        assertTrue(title.getRolesAtOther().isEmpty());
        assertTrue(title.getGrantableRoles().isEmpty());
        assertTrue(title.getGrantableRolesAtBase().isEmpty());
        assertTrue(title.getGrantableRolesAtHQ().isEmpty());
        assertTrue(title.getGrantableRolesAtOther().isEmpty());

        assertEquals(2, title.getRoles().size());
        assertTrue(title.getRoles().contains(RoleType.HANGAR_TAKE_6));
        assertTrue(title.getRoles().contains(RoleType.HANGAR_QUERY_2));
    }
}