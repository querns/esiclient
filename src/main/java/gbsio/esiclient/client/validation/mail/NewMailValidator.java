package gbsio.esiclient.client.validation.mail;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.common.mail.Recipient;
import gbsio.esiclient.api.domain.request.mail.NewMail;

public class NewMailValidator {
    public static void validate(NewMail mail) throws IllegalArgumentException {
        Preconditions.checkArgument(mail.getBody().length() <= 10000, "Mail's body must be 10,000 or fewer characters");
        Preconditions.checkArgument(mail.getSubject().length() <= 1000, "Mail's subject must be 1,000 or fewer characters");

        final int size = mail.getRecipients().size();
        Preconditions.checkArgument(size > 0, "Mail must have at least one recipient");
        Preconditions.checkArgument(size <= 50, "Mail can have at most 50 recipients");

        mail.getRecipients().forEach(recipient -> Preconditions.checkArgument(
            recipient.getType() != Recipient.Type.UNKNOWN,
            "Recipient with ID #%d cannot be of type UNKNOWN",
            recipient.getID())
        );
    }
}
