package gbsio.functional.request.authenticated.mail;

import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.common.mail.LabelColor;
import gbsio.esiclient.api.domain.response.mail.LabelDataContainer;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.domain.mail.NewLabelBuilder;
import gbsio.esiclient.client.request.mail.DeleteLabelRequest;
import gbsio.esiclient.client.request.mail.LabelsRequest;
import gbsio.esiclient.client.request.mail.CreateLabelRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MailLabelsTest extends FunctionalTestHarness {
    @Test
    void labels() throws IOException {
        Client client = getClient();
        int characterID = getPropertyAsInt("promfem_id");
        String accessToken = getAccessToken("my_5s_token");

        final Response<LabelDataContainer> labelsResponse = client.sendRequest(new LabelsRequest(
            characterID, accessToken
        )).join();

        final LabelDataContainer labels = assertResponseExistsAndGet(labelsResponse);
        assertNotNull(labels);

        final Response<Integer> newLabelResponse = client.sendRequest(new CreateLabelRequest(
            characterID, accessToken, new NewLabelBuilder(LabelColor.COLOR_FFFFFF, "Test Label").build()
        )).join();

        Integer newLabelID = assertResponseExistsAndGet(newLabelResponse);
        assertNotNull(newLabelID);

        final BooleanResponse deleteResponse = client.sendRequest(new DeleteLabelRequest(
            characterID, accessToken, newLabelID
        )).join();

        assertBooleanResponseCompletedNormally(deleteResponse);
        assertTrue(deleteResponse.wasSuccessful());
    }
}