package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.MiningObserver;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiningObserverImplTest {
    @Test
    void parse() throws IOException, ParseException {
        ImmutableList<MiningObserver> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/industry/observer.json"),
            new TypeReference<ImmutableList<MiningObserver>>() { }
        );

        assertEquals(1, list.size());
        MiningObserver observer = list.get(0);

        assertEquals(LocalDate.parse("2017-09-19"), observer.getLastUpdatedDate());
        assertEquals(1, observer.getID());
        assertEquals(MiningObserver.ObserverType.STRUCTURE, observer.getType());
    }
}