package gbsio.esiclient.internal.domain.response.fitting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.fittings.RetrievedFitting;
import gbsio.esiclient.api.domain.common.fittings.Item;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RetrievedFittingImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<RetrievedFitting> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/fitting/fitting.json"),
            new TypeReference<ImmutableList<RetrievedFitting>>() { }
        );

        assertEquals(1, list.size());
        RetrievedFitting fitting = list.get(0);

        //noinspection SpellCheckingInspection
        assertEquals("Awesome Vindi fitting", fitting.getDescription());
        assertEquals(1, fitting.getID());
        assertEquals("Best Vindicator", fitting.getName());
        assertEquals(123, fitting.getShipItemTypeID());

        assertEquals(1, fitting.getItems().size());
        Item item = fitting.getItems().get(0);

        assertEquals(12, item.getFlag());
        assertEquals(1, item.getQuantity());
        assertEquals(1234, item.getItemTypeID());
    }
}