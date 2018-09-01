package gbsio.esiclient.client.request.character;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AffiliationRequestTest {
    @Test
    void validate() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new AffiliationRequest(ImmutableList.of()),
            "Expected an empty list to be invalid"
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> new AffiliationRequest(ImmutableList.copyOf(IntStream.rangeClosed(1, 1001).boxed().collect(Collectors.toList()))),
            "Expected a list of more than 1,000 character IDs to throw"
        );
    }
}