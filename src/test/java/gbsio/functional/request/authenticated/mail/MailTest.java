package gbsio.functional.request.authenticated.mail;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.common.mail.Recipient;
import gbsio.esiclient.api.domain.response.mail.Mail;
import gbsio.esiclient.api.domain.response.mail.MailHeader;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.domain.mail.MailMetadataBuilder;
import gbsio.esiclient.client.domain.mail.NewMailBuilder;
import gbsio.esiclient.client.request.mail.*;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MailTest extends FunctionalTestHarness {
    @Test
    void mail() throws IOException {
        Client client = getClient();
        final int senderCharacterID = getPropertyAsInt("querns_id");
        final String senderToken = getAccessToken("querns_token");
        final int recipientCharacterID = getPropertyAsInt("promfem_id");
        final String recipientToken = getAccessToken("my_5s_token");

        // -- Get mail headers
        final Response<ImmutableList<MailHeader>> headersResponse = client.sendRequest(new MailHeadersRequest(
            recipientCharacterID, recipientToken
        )).join();
        final ImmutableList<MailHeader> headersList = assertResponseExistsAndGet(headersResponse);

        assertTrue(headersList.size() > 0);
        MailHeader mailHeader = headersList.get(0);
        assertTrue(mailHeader.getMailID().isPresent());

        // -- Get mail details
        final Response<Mail> mailResponse = client.sendRequest(new MailDetailRequest(
            recipientCharacterID, recipientToken, mailHeader.getMailID().get()
        )).join();
        final Mail mail = assertResponseExistsAndGet(mailResponse);
        assertNotNull(mail);

        // -- Send new mail
        final Response<Integer> sendMailResponse = client.sendRequest(new SendMailRequest(
            senderCharacterID,
            senderToken,
            new NewMailBuilder("mail body", "mail subject")
                .addRecipient(recipientCharacterID, Recipient.Type.CHARACTER)
                .build()
        )).join();
        final Integer newMailID = assertResponseExistsAndGet(sendMailResponse);
        assertNotNull(newMailID);

        // -- Mark mail read
        final BooleanResponse metadataResponse = client.sendRequest(new UpdateMailMetadataRequest(
            recipientCharacterID, recipientToken, newMailID, new MailMetadataBuilder(true).build()
        )).join();
        assertBooleanResponseCompletedNormally(metadataResponse);
        assertTrue(metadataResponse.wasSuccessful());

        // -- Delete mail
        final BooleanResponse deleteResponse = client.sendRequest(new DeleteMailRequest(
            recipientCharacterID, recipientToken, newMailID
        )).join();
        assertBooleanResponseCompletedNormally(deleteResponse);
        assertTrue(deleteResponse.wasSuccessful());
    }
}