package gbsio.esiclient.api.domain.response.mail;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.mail.MailImpl;

import java.util.Optional;

/**
 * Represents a mail sent by a character to another character, corporation,
 * alliance, or mailing list.
 */
@JsonDeserialize(as = MailImpl.class)
public interface Mail extends MailHeader {
    /**
     * Gets the body of the mail.
     *
     * @return the mail body
     */
    Optional<String> getBody();
}
