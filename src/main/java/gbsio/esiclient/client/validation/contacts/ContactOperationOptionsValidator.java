package gbsio.esiclient.client.validation.contacts;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import gbsio.esiclient.api.domain.request.contacts.ContactOperationOptions;

public class ContactOperationOptionsValidator {
    public static void validate(ContactOperationOptions edits) throws IllegalArgumentException {
        Preconditions.checkArgument(
            edits.getContactIDs().size() > 0,
            "There must be at least one contact ID to operate upon"
        );

        Preconditions.checkArgument(
            edits.getContactIDs().size() <= 100,
            "There must be no more than 100 contact IDs to operate upon"
        );

        Preconditions.checkArgument(
            Range.closed(-10F, 10F).contains(edits.getStanding()),
            "Standing level must be a float between -10.0 and 10.0, inclusive"
        );
    }
}
