package gbsio.esiclient.client.validation.ui;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.ui.PrefilledMail;

public class PrefilledMailValidator {
    public static void validate(PrefilledMail mail) {
        Preconditions.checkNotNull(mail);
        Preconditions.checkArgument(mail.getBody().length() > 0, "The mail's body must have at least one character");
        Preconditions.checkArgument(mail.getBody().length() <= 10000, "The mail's body cannot be longer than 10,000 characters");
        Preconditions.checkArgument(mail.getRecipients().size() > 0, "The mail must have at least one recipient");
        Preconditions.checkArgument(mail.getRecipients().size() <= 50, "The mail can have at most 50 recipients");
        Preconditions.checkArgument(mail.getSubject().length() <= 1000, "The mail's subject can have at most 1,000 characters");

        final boolean corpIDPresent = mail.getCorporationOrAllianceRecipientID().isPresent();
        final boolean mailingListPresent = mail.getMailingListRecipientID().isPresent();

        Preconditions.checkArgument(
            !(corpIDPresent && mailingListPresent),
            "The mail cannot target both a mailing list and corporation/alliance"
        );
    }
}
