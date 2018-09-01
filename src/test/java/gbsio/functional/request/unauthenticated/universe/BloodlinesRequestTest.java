package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.Bloodline;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.BloodlinesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloodlinesRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Bloodline>> response = getClient().sendRequest(new BloodlinesRequest(Language.JA)).join();
        final ImmutableList<Bloodline> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}