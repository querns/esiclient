package gbsio.esiclient.client.domain.mail;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.common.mail.Recipient;
import gbsio.esiclient.api.domain.request.mail.NewMail;
import gbsio.esiclient.client.validation.mail.NewMailValidator;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NewMailValidatorTest {
    private static final Recipient VALID_RECIPIENT = new NewMailBuilder.RecipientImpl(1, Recipient.Type.CHARACTER);
    private static final String VALID_SUBJECT = "Subject";
    private static final String VALID_BODY = "Body";

    @Test
    void validate() {
        ImmutableSet.Builder<Recipient> builder = ImmutableSet.builder();
        for (int i = 0; i < 51; i++) {
            builder.add(new NewMailBuilder.RecipientImpl(i, Recipient.Type.CHARACTER));
        }

        List<Pair<NewMail, String>> list = ImmutableList.of(
            new Pair<>(new NewMailBuilder.NewMailImpl(null, new String(new char[10001]), ImmutableSet.of(VALID_RECIPIENT), VALID_SUBJECT), "mail with >10,000 character body"),
            new Pair<>(new NewMailBuilder.NewMailImpl(null, VALID_BODY, ImmutableSet.of(VALID_RECIPIENT), new String(new char[1001])), "mail with >1,000 character subject"),
            new Pair<>(new NewMailBuilder.NewMailImpl(null, VALID_BODY, ImmutableSet.of(), VALID_SUBJECT), "mail with no recipients"),
            new Pair<>(new NewMailBuilder.NewMailImpl(null, VALID_BODY, builder.build(), VALID_SUBJECT), "mail with too many recipients"),
            new Pair<>(new NewMailBuilder.NewMailImpl(null, VALID_BODY, ImmutableSet.of(new NewMailBuilder.RecipientImpl(1, Recipient.Type.UNKNOWN)), VALID_SUBJECT), "mail with an UNKNOWN subject")
        );

        list.forEach(pair -> assertThrows(
            IllegalArgumentException.class,
            () -> NewMailValidator.validate(pair.getValue0()),
            String.format("Expected IllegalArgumentException for %s", pair.getValue1())
        ));
    }
}