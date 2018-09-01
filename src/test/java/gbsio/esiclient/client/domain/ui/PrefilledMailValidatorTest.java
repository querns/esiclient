package gbsio.esiclient.client.domain.ui;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.ui.PrefilledMail;
import gbsio.esiclient.client.validation.ui.PrefilledMailValidator;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PrefilledMailValidatorTest {
    private static final Integer MAILING_GROUP_ID = null;
    private static final String SUBJECT = "subject";
    private static final int RECIPIENT = 123;
    private static final String BODY = "body";

    @Test
    void validate() {
        final ImmutableList<Integer> VALID_RECIPIENTS = ImmutableList.of(RECIPIENT);
        ImmutableList<Pair<PrefilledMail, String>> list = ImmutableList.of(
            new Pair<>(new PrefilledMailBuilder.PrefilledMailImpl("", VALID_RECIPIENTS, SUBJECT, MAILING_GROUP_ID, MAILING_GROUP_ID), "Expected mail with empty body to not validate"),
            new Pair<>(new PrefilledMailBuilder.PrefilledMailImpl(new String(new char[10001]), VALID_RECIPIENTS, SUBJECT, MAILING_GROUP_ID, MAILING_GROUP_ID), "Expected mail with 10,001 character body to not validate"),
            new Pair<>(new PrefilledMailBuilder.PrefilledMailImpl(BODY, ImmutableList.of(), SUBJECT, MAILING_GROUP_ID, MAILING_GROUP_ID), "Expected mail with no recipients to not validate"),
            new Pair<>(new PrefilledMailBuilder.PrefilledMailImpl(BODY, VALID_RECIPIENTS, new String(new char[1001]), MAILING_GROUP_ID, MAILING_GROUP_ID), "Expected mail with 1,001 character subject to not validate"),
            new Pair<>(new PrefilledMailBuilder.PrefilledMailImpl(BODY, VALID_RECIPIENTS, new String(new char[1001]), RECIPIENT, RECIPIENT), "Expected mail with both corp/alliance ID and mailing list ID set to not validate")
        );

        list.forEach(pair -> assertThrows(
            IllegalArgumentException.class,
            () -> PrefilledMailValidator.validate(pair.getValue0()),
            pair.getValue1()
        ));

        assertThrows(NullPointerException.class, () -> PrefilledMailValidator.validate(null), "Expected a null mail to not validate");
    }
}