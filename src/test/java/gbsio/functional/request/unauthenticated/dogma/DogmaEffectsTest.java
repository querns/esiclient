package gbsio.functional.request.unauthenticated.dogma;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.dogma.DogmaEffect;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.dogma.DogmaEffectDetailRequest;
import gbsio.esiclient.client.request.dogma.DogmaEffectsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogmaEffectsTest extends FunctionalTestHarness {
    @Test
    void request() {
        Client client = getClient();

        final Response<ImmutableList<Integer>> listResponse = client.sendRequest(new DogmaEffectsRequest()).join();
        final ImmutableList<Integer> list = assertResponseExistsAndGet(listResponse);

        assertTrue(list.size() > 0);
        Integer effectID = list.get(0);

        final Response<DogmaEffect> effectResponse = client.sendRequest(new DogmaEffectDetailRequest(effectID)).join();
        final DogmaEffect effect = assertResponseExistsAndGet(effectResponse);
        assertNotNull(effect);
    }
}