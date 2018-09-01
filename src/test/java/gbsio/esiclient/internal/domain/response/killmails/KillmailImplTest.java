package gbsio.esiclient.internal.domain.response.killmails;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.killmails.Attacker;
import gbsio.esiclient.api.domain.response.killmails.Item;
import gbsio.esiclient.api.domain.response.killmails.Killmail;
import gbsio.esiclient.api.domain.response.killmails.Victim;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KillmailImplTest {
    @Test
    void parse() throws IOException {
        Killmail killmail = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/killmails/killmail.json"),
            new TypeReference<Killmail>() { }
        );

        assertEquals(56733821, killmail.getID());
        assertEquals(ZonedDateTime.parse("2016-10-22T17:13:36Z"), killmail.getDate());
        assertEquals(30002976, killmail.getSolarSystemID());
        assertFalse(killmail.getMoonID().isPresent());
        assertFalse(killmail.getWarID().isPresent());

        assertEquals(1, killmail.getAttackers().size());
        Attacker attacker = killmail.getAttackers().get(0);

        assertTrue(attacker.getCharacterID().isPresent());
        assertEquals((Integer)95810944, attacker.getCharacterID().get());
        assertTrue(attacker.getCorporationID().isPresent());
        assertEquals((Integer)1000179, attacker.getCorporationID().get());
        assertEquals(5745, attacker.getDamageDone());
        assertTrue(attacker.getFactionID().isPresent());
        assertEquals((Integer)500003, attacker.getFactionID().get());
        assertTrue(attacker.dealtFinalBlow());
        assertEquals(-0.3F, attacker.getSecurityStatus());
        assertTrue(attacker.getShipItemTypeID().isPresent());
        assertEquals((Integer)17841, attacker.getShipItemTypeID().get());
        assertTrue(attacker.getWeaponItemTypeID().isPresent());
        assertEquals((Integer)3074, attacker.getWeaponItemTypeID().get());

        Victim victim = killmail.getVictim();
        assertTrue(victim.getAllianceID().isPresent());
        assertEquals((Integer)621338554, victim.getAllianceID().get());
        assertTrue(victim.getCharacterID().isPresent());
        assertEquals((Integer)92796241, victim.getCharacterID().get());
        assertTrue(victim.getCorporationID().isPresent());
        assertEquals((Integer)841363671, victim.getCorporationID().get());
        assertEquals(5745, victim.getDamageTaken());
        assertTrue(victim.getShipItemTypeID().isPresent());
        assertEquals((Integer)17812, victim.getShipItemTypeID().get());

        assertEquals(1, victim.getItems().size());
        Item item = victim.getItems().get(0);
        assertEquals(20, item.getFlag());
        assertEquals(5973, item.getItemTypeID());
        assertTrue(item.getQuantityDropped().isPresent());
        assertEquals((Long)1L, item.getQuantityDropped().get());
        assertFalse(item.getQuantityDestroyed().isPresent());
        assertEquals(0, item.getContainedItems().size());
        assertEquals(0, item.getSingleton());

        Coordinates coordinates = victim.getPosition();
        assertEquals(452186600569.4748D, coordinates.getX());
        assertEquals(146704961490.90222D, coordinates.getY());
        assertEquals(109514596532.54477D, coordinates.getZ());
    }
}