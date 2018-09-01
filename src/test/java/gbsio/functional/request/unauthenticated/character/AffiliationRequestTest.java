package gbsio.functional.request.unauthenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.Affiliation;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.AffiliationRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AffiliationRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final int quernsID = getPropertyAsInt("querns_id");
        final int promfemID = getPropertyAsInt("promfem_id");

        final Response<ImmutableList<Affiliation>> response = getClient().sendRequest(new AffiliationRequest(
            ImmutableList.of(quernsID, promfemID)
        )).join();

        final ImmutableList<Affiliation> affiliations = assertResponseExistsAndGet(response);

        assertEquals(2, affiliations.size(), "Expected two results from ESI");
        assertTrue(
            affiliations.stream()
                .filter(affiliation -> quernsID == affiliation.getCharacterID())
                .collect(Collectors.toList())
                .size() > 0,
            "Expected Querns to be in the list"
        );

        assertTrue(
            affiliations.stream()
                .filter(affiliation -> promfemID == affiliation.getCharacterID())
                .collect(Collectors.toList())
                .size() > 0,
            "Expected Promiscuous Female to be in the list"
        );
    }

}