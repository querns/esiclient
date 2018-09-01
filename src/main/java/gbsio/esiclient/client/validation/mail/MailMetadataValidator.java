package gbsio.esiclient.client.validation.mail;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.common.mail.MailMetadata;

public class MailMetadataValidator {
    public static void validate(MailMetadata metadata) {
        Preconditions.checkArgument(metadata.getLabelIDs().size() <= 25, "Mails can have at most 25 label IDs");
    }
}
