package gbsio.esiclient.client.domain.mail;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.common.mail.MailMetadata;
import gbsio.esiclient.client.validation.mail.MailMetadataValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailMetadataValidatorTest {
    @Test
    void validate() {
        ImmutableList.Builder<Integer> builder = ImmutableList.builder();

        for (int i = 0; i < 26; i++) {
            builder.add(i);
        }

        MailMetadata metadata = new MailMetadataBuilder.MailMetadataImpl(builder.build(), true);

        assertThrows(
            IllegalArgumentException.class,
            () -> MailMetadataValidator.validate(metadata)
        );
    }
}