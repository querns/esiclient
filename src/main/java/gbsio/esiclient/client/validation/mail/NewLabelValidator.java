package gbsio.esiclient.client.validation.mail;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import gbsio.esiclient.api.domain.common.mail.LabelColor;
import gbsio.esiclient.api.domain.request.mail.NewLabel;

public class NewLabelValidator {
    public static void validate(NewLabel newLabel) {
        if (newLabel.getColor().isPresent()) {
            Preconditions.checkArgument(
                newLabel.getColor().get() != LabelColor.UNKNOWN,
                "Label's color cannot be UNKNOWN"
            );
        }

        Preconditions.checkArgument(
            Range.closed(1, 40).contains(newLabel.getName().length()),
            "Label's name must be between 1 and 40 characters"
        );
    }
}
