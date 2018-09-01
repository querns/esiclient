package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.ContainerAuditLog;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ContainerAuditLogImplTest {

    @Test
    void parse() throws IOException {
        ImmutableList<ContainerAuditLog> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/containerAuditLog.json"),
            new TypeReference<ImmutableList<ContainerAuditLog>>() { }
        );

        assertEquals(3, list.size());
        ContainerAuditLog one = list.get(0);
        ContainerAuditLog two = list.get(1);
        ContainerAuditLog three = list.get(2);

        assertEquals(ContainerAuditLog.Action.SET_PASSWORD, one.getAction());
        assertEquals(2112625428, one.getCharacterID());
        assertEquals(1000000012279L, one.getContainerID());
        assertEquals(17365, one.getContainerTypeID());
        assertEquals("CorpSAG1", one.getLocationFlag());
        assertEquals(1000000012278L, one.getLocationID());
        assertEquals(ZonedDateTime.parse("2017-10-10T14:00:00Z"), one.getDate());
        assertTrue(one.getPasswordType().isPresent());
        assertEquals(ContainerAuditLog.PasswordType.GENERAL, one.getPasswordType().get());

        assertEquals(ContainerAuditLog.Action.LOCK, two.getAction());
        assertEquals(2112625428, two.getCharacterID());
        assertEquals(1000000012279L, two.getContainerID());
        assertEquals(17365, two.getContainerTypeID());
        assertEquals("CorpSAG1", two.getLocationFlag());
        assertEquals(1000000012278L, two.getLocationID());
        assertEquals(ZonedDateTime.parse("2017-10-11T12:04:33Z"), two.getDate());
        assertTrue(two.getQuantity().isPresent());
        assertEquals((Integer)30, two.getQuantity().get());
        assertTrue(two.getItemTypeID().isPresent());
        assertEquals((Integer)1230, two.getItemTypeID().get());

        assertEquals(ContainerAuditLog.Action.CONFIGURE, three.getAction());
        assertEquals(2112625428, three.getCharacterID());
        assertEquals(1000000012279L, three.getContainerID());
        assertEquals(17365, three.getContainerTypeID());
        assertEquals("CorpSAG2", three.getLocationFlag());
        assertEquals(1000000012278L, three.getLocationID());
        assertEquals(ZonedDateTime.parse("2017-10-11T12:06:29Z"), three.getDate());
        assertTrue(three.getNewConfigBitmask().isPresent());
        assertEquals((Integer)31, three.getNewConfigBitmask().get());
        assertTrue(three.getOldConfigBitmask().isPresent());
        assertEquals((Integer)23, three.getOldConfigBitmask().get());
    }
}