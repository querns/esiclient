package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Stargate;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StargateImplTest {
    @Test
    void parse() throws IOException {
        Stargate stargate = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/stargate.json"),
            new TypeReference<Stargate>() { }
        );

        assertEquals(50000056, stargate.getDestinationStargateID());
        assertEquals(30000001, stargate.getDestinationSolarSystemID());
        //noinspection SpellCheckingInspection
        assertEquals("Stargate (Tanoo)", stargate.getName());
        assertEquals(-101092761600D, stargate.getPosition().getX());
        assertEquals(5279539200D, stargate.getPosition().getY());
        assertEquals(1550503403520D, stargate.getPosition().getZ());
        assertEquals(50000342, stargate.getID());
        assertEquals(30000003, stargate.getSolarSystemID());
        assertEquals(29624, stargate.getItemTypeID());
    }
}