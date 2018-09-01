package gbsio.esiclient.internal.domain.response.location;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.location.OnlineStatus;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OnlineStatusImplTest {
    @Test
    void parse() throws IOException {
        OnlineStatus status = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/location/onlineStatus.json"),
            new TypeReference<OnlineStatus>() { }
        );

        assertTrue(status.getLastLogin().isPresent());
        assertTrue(status.getLastLogout().isPresent());
        assertTrue(status.getLoginCount().isPresent());
        assertEquals(ZonedDateTime.parse("2017-01-02T03:04:05Z"), status.getLastLogin().get());
        assertEquals(ZonedDateTime.parse("2017-01-02T04:05:06Z"), status.getLastLogout().get());
        assertEquals((Integer)9001, status.getLoginCount().get());
        assertTrue(status.isOnline());
    }
}