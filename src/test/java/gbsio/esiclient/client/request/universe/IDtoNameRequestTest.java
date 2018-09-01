package gbsio.esiclient.client.request.universe;

import com.google.common.collect.ImmutableList;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class IDtoNameRequestTest {
    @Test
    void validate() {
        ImmutableList.Builder<Integer> builder = ImmutableList.builder();
        for (int i = 0; i <= 1001; i++) {
            builder.add(i);
        }

        List<Pair<ImmutableList<Integer>, String>> list = ImmutableList.of(
            new Pair<>(ImmutableList.of(), "Expected empty list to throw an exception"),
            new Pair<>(builder.build(), "Expected list of more than 1000 elements to throw an exception")
        );

        list.forEach(pair -> assertThrows(
            IllegalArgumentException.class,
            () -> new IDtoNameRequest(pair.getValue0()),
            pair.getValue1()
        ));
    }
}