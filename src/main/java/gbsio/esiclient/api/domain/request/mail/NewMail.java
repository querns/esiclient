package gbsio.esiclient.api.domain.request.mail;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.common.mail.Recipient;

import java.util.Optional;

/**
 * Represents the information required to send a new mail.
 */
public interface NewMail {
    /**
     * Gets the CSPA cost necessary to send this mail.
     *
     * CSPA (CONCORD Spam Prevention Act) costs are levied towards mail senders
     * as a method to reduce unwanted mail. This value must match the sum of the
     * CSPA costs of all recipients, or the mail will not successfully be sent.
     *
     * @return the approved cost
     * @see gbsio.esiclient.client.request.character.CSPACostRequest
     */
    @JsonGetter("approved_cost")
    Optional<Double> getApprovedCost();

    /**
     * Gets the body of the mail.
     *
     * @return the mail body
     */
    @JsonGetter("body")
    String getBody();

    /**
     * Gets the recipients for this mail.
     *
     * @return the recipients
     */
    @JsonGetter("recipients")
    ImmutableSet<Recipient> getRecipients();

    /**
     * Gets the subject for the mail.
     *
     * @return the subject
     */
    @JsonGetter("subject")
    String getSubject();
}
