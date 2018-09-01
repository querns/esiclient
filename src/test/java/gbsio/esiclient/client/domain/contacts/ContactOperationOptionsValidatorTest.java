package gbsio.esiclient.client.domain.contacts;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.request.contacts.ContactOperationOptions;
import gbsio.esiclient.client.validation.contacts.ContactOperationOptionsValidator;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactOperationOptionsValidatorTest {
    private static final float VALID_STANDING = 0F;
    private static final ImmutableSet<Integer> VALID_CONTACT_ID_LIST = ImmutableSet.of(123);
    private static final ImmutableSet<Integer> VALID_LABEL_ID_LIST = ImmutableSet.of();
    private static final boolean WATCHLIST = false;

    @Test
    void validate() {
        final ImmutableSet.Builder<Integer> setBuilder = ImmutableSet.builder();
        for (int i = 0; i < 102; i++) {
            setBuilder.add(i);
        }
        List<Pair<ContactOperationOptions, String>> list = ImmutableList.of(
            new Pair<>(new ContactOperationOptionsBuilder.Impl(
                ImmutableSet.of(),
                VALID_STANDING,
                VALID_LABEL_ID_LIST,
                WATCHLIST
            ), "Expected 0 contact IDs to throw"),

            new Pair<>(new ContactOperationOptionsBuilder.Impl(
                setBuilder.build(),
                VALID_STANDING,
                VALID_LABEL_ID_LIST,
                WATCHLIST
            ), "Expected 101 contact IDs to throw"),

            new Pair<>(new ContactOperationOptionsBuilder.Impl(
                VALID_CONTACT_ID_LIST,
                -20F,
                VALID_LABEL_ID_LIST,
                WATCHLIST
            ), "Expected standings below -10.0 to throw"),

            new Pair<>(new ContactOperationOptionsBuilder.Impl(
                VALID_CONTACT_ID_LIST,
                20F,
                VALID_LABEL_ID_LIST,
                WATCHLIST
            ), "Expected standings above -10.0 to throw")
        );

        list.forEach(pair -> assertThrows(
            IllegalArgumentException.class,
            () -> ContactOperationOptionsValidator.validate(pair.getValue0()),
            pair.getValue1()
        ));
    }
}