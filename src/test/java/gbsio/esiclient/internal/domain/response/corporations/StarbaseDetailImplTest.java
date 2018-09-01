package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.corporation.StarbaseDetail;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StarbaseDetailImplTest {
    @Test
    void parse() throws IOException {
        StarbaseDetail detail = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/starbaseDetail.json"),
            new TypeReference<StarbaseDetail>() { }
        );

        assertFalse(detail.areAllianceMembersAllowed());
        assertTrue(detail.areCorporationMembersAllowed());
        assertEquals(StarbaseDetail.StarbaseConfigurer.CONFIG_STARBASE_EQUIPMENT_ROLE, detail.getAnchorPermission());
        assertTrue(detail.willAttackAtWar());
        assertFalse(detail.willAttackOnSecurityStatusDrop());
        assertEquals(StarbaseDetail.StarbaseConfigurer.CONFIG_STARBASE_EQUIPMENT_ROLE, detail.getFuelBayTakePermission());
        assertEquals(StarbaseDetail.StarbaseConfigurer.CONFIG_STARBASE_EQUIPMENT_ROLE, detail.getFuelBayViewPermission());
        assertEquals(StarbaseDetail.StarbaseConfigurer.CONFIG_STARBASE_EQUIPMENT_ROLE, detail.getOfflinePermission());
        assertEquals(StarbaseDetail.StarbaseConfigurer.CONFIG_STARBASE_EQUIPMENT_ROLE, detail.getOnlinePermission());
        assertEquals(StarbaseDetail.StarbaseConfigurer.CONFIG_STARBASE_EQUIPMENT_ROLE, detail.getUnanchorPermission());
        assertFalse(detail.willUseAllianceStandings());

        assertFalse(detail.getAttackStandingsThreshold().isPresent());
        assertFalse(detail.getAttackSecurityStatusThreshold().isPresent());

        assertEquals(1, detail.getFuels().size());
        StarbaseDetail.Fuel fuel = detail.getFuels().get(0);

        assertEquals(123, fuel.getQuantity());
        assertEquals(456, fuel.getItemTypeID());
    }
}