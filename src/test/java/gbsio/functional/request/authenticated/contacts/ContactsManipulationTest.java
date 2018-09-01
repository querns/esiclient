package gbsio.functional.request.authenticated.contacts;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.domain.contacts.ContactOperationOptionsBuilder;
import gbsio.esiclient.client.request.contacts.AddContactsRequest;
import gbsio.esiclient.client.request.contacts.DeleteContactsRequest;
import gbsio.esiclient.client.request.contacts.EditContactsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactsManipulationTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Client client = getClient();
        final int theMittaniID = getPropertyAsInt("the_mittani_id");
        final int characterID = getPropertyAsInt("querns_id");
        final String accessToken = getAccessToken("querns_token");

        final Response<ImmutableList<Integer>> addResponse = client.sendRequest(new AddContactsRequest(
            characterID,
            accessToken,
            new ContactOperationOptionsBuilder(10F)
                .addContactID(theMittaniID)
                .build()
        )).join();

        final ImmutableList<Integer> addedContactsList = assertResponseExistsAndGet(addResponse);
        assertEquals(1, addedContactsList.size());

        final BooleanResponse editResponse = client.sendRequest(new EditContactsRequest(
            characterID, accessToken,
            new ContactOperationOptionsBuilder(5F)
                .addContactID(theMittaniID)
                .build()
        )).join();

        assertBooleanResponseCompletedNormally(editResponse);
        assertTrue(editResponse.wasSuccessful());
        assertFalse(editResponse.isDeprecated());

        final BooleanResponse deleteResponse = client.sendRequest(new DeleteContactsRequest(
            characterID, accessToken, ImmutableList.of(theMittaniID)
        )).join();

        assertBooleanResponseCompletedNormally(deleteResponse);
        assertTrue(deleteResponse.wasSuccessful());
        assertFalse(deleteResponse.isDeprecated());
    }
}