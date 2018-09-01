package gbsio.esiclient.internal.domain.response.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.fleets.FleetMember;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FleetMemberImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<FleetMember> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/fleets/fleetMember.json"),
            new TypeReference<ImmutableList<FleetMember>>() { }
        );

        assertEquals(2, list.size());
        FleetMember fleetMember = list.get(0);
        FleetMember missingInfo = list.get(1);

        assertEquals(93265215, fleetMember.getCharacterID());
        assertEquals(ZonedDateTime.parse("2016-04-29T12:34:56Z"), fleetMember.getJoinDate());
        assertEquals(Role.SQUAD_COMMANDER, fleetMember.getRole());
        assertEquals("Squad Commander (Boss)", fleetMember.getRoleName());
        assertEquals(33328, fleetMember.getShipTypeID());
        assertEquals(30003729, fleetMember.getSolarSystemID());
        assertTrue(fleetMember.getSquadID().isPresent());
        assertEquals((Long)3129411261968L, fleetMember.getSquadID().get());
        assertTrue(fleetMember.getWingID().isPresent());
        assertEquals((Long)2073711261968L, fleetMember.getWingID().get());
        assertTrue(fleetMember.willTakeFleetWarp());
        assertTrue(fleetMember.getStationID().isPresent());
        assertEquals((Long)61000180L, fleetMember.getStationID().get());

        assertFalse(missingInfo.getSquadID().isPresent());
        assertFalse(missingInfo.getWingID().isPresent());
        assertFalse(missingInfo.getStationID().isPresent());
    }
}