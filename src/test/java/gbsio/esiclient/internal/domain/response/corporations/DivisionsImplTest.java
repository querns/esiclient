package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.corporation.Divisions;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DivisionsImplTest {

    @Test
    void parse() throws IOException {
        Divisions divisions = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/divisions.json"),
            new TypeReference<Divisions>() { }
        );

        assertEquals(1, divisions.getHangars().size());
        assertEquals(1, divisions.getWallets().size());

        Divisions.DivisionLabel hangar = divisions.getHangars().get(0);
        Divisions.DivisionLabel wallet = divisions.getWallets().get(0);

        assertTrue(hangar.getDivision().isPresent());
        assertEquals((Integer)1, hangar.getDivision().get());
        assertTrue(hangar.getName().isPresent());
        assertEquals("Awesome Hangar 1", hangar.getName().get());

        assertTrue(wallet.getDivision().isPresent());
        assertEquals((Integer)1, wallet.getDivision().get());
        assertTrue(wallet.getName().isPresent());
        assertEquals("Rich Wallet 1", wallet.getName().get());
    }
}