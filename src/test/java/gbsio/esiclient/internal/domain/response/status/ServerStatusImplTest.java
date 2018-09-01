package gbsio.esiclient.internal.domain.response.status;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.status.ServerStatus;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ServerStatusImplTest {
    @Test
    void parse() throws IOException {
        ServerStatus serverStatus = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/status/status.json"),
            new TypeReference<ServerStatus>() { }
        );

        assertFalse(serverStatus.getVIPStatus().isPresent());
        assertEquals(12345, serverStatus.getPlayerCount());
        assertEquals("1132976", serverStatus.getServerVersion());
        assertEquals(ZonedDateTime.parse("2017-01-02T12:34:56Z"), serverStatus.getStartDate());
    }
}