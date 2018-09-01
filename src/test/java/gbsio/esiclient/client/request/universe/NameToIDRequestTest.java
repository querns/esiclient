package gbsio.esiclient.client.request.universe;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NameToIDRequestTest {
    @Test
    void validate() {
        ImmutableSet.Builder<String> builder = ImmutableSet.builder();
        for (int i = 0; i <= 1002; i++) {
            builder.add("test".concat(String.valueOf(i)));
        }

        List<Pair<ImmutableSet<String>, String>> list = ImmutableList.of(
            new Pair<>(ImmutableSet.of(), "Expected a 0-length list to throw an exception"),
            new Pair<>(builder.build(), "Expected a list of length 1001 to throw an exception")
        );

        list.forEach(pair -> assertThrows(
            IllegalArgumentException.class,
            () -> new NameToIDRequest(pair.getValue0()),
            pair.getValue1()
        ));
    }
}