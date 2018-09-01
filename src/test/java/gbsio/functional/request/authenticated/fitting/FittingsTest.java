package gbsio.functional.request.authenticated.fitting;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.common.fittings.Fitting;
import gbsio.esiclient.api.domain.response.fittings.RetrievedFitting;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.domain.fitting.FittingBuilder;
import gbsio.esiclient.client.request.fitting.DeleteFittingRequest;
import gbsio.esiclient.client.request.fitting.GetFittingsRequest;
import gbsio.esiclient.client.request.fitting.SaveFittingRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FittingsTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Client client = getClient();
        final int characterID = getPropertyAsInt("querns_id");
        final String accessToken = getAccessToken("querns_token");

        final Response<ImmutableList<RetrievedFitting>> fittingsResponse = client.sendRequest(
            new GetFittingsRequest(characterID, accessToken)
        ).join();

        final ImmutableList<RetrievedFitting> list = assertResponseExistsAndGet(fittingsResponse);
        assertTrue(list.size() > 0);
        RetrievedFitting fitting = list.get(0);

        Fitting newFitting = new FittingBuilder(
            "Fit for testing the ESI client",
            "Test Fit",
            getPropertyAsInt("claw_item_type_id")
        ).addItem(fitting.getItems().get(0)).build();

        final Response<Integer> saveResponse = client.sendRequest(new SaveFittingRequest(characterID, accessToken, newFitting)).join();
        final Integer newFittingID = assertResponseExistsAndGet(saveResponse);

        assertNotNull(newFittingID);

        final BooleanResponse deleteResponse = client.sendRequest(new DeleteFittingRequest(
            characterID, accessToken, newFittingID
        )).join();

        assertBooleanResponseCompletedNormally(deleteResponse);
        assertTrue(deleteResponse.wasSuccessful());
    }
}