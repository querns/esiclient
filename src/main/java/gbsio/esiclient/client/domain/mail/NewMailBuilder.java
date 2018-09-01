package gbsio.esiclient.client.domain.mail;

import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.common.mail.Recipient;
import gbsio.esiclient.api.domain.request.mail.NewMail;
import gbsio.esiclient.client.request.character.CSPACostRequest;
import gbsio.esiclient.client.validation.mail.NewMailValidator;

import java.util.Objects;
import java.util.Optional;

/**
 * Creates a new mail to send.
 * <p>
 *     New mails must adhere to the following constraints:
 *     <ul>
 *         <li>The mail body must be no more than 10,000 characters, including HTML markup.</li>
 *         <li>The mail subject must be no more than 1,000 characters.</li>
 *         <li>A mail can have no fewer than 1 and no more than 50 recipients. </li>
 *         <li>Recipients cannot be of type {@link Recipient.Type#UNKNOWN}.</li>
 *     </ul>
 * </p>
 */
final public class NewMailBuilder {
    private final ImmutableSet.Builder<Recipient> recipientBuilder = ImmutableSet.builder();

    private String body;
    private String subject;
    private Double approvedCost = 0D;

    @SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
    public NewMailBuilder(final String body, final String subject) {
        this.body = body;
        this.subject = subject;
    }

    @SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
    public NewMailBuilder(final String body, final String subject, Recipient recipient) {
        this(body, subject);
        recipientBuilder.add(recipient);
    }

    @SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
    public NewMailBuilder(final String body, final String subject, Recipient ...recipients) {
        this(body, subject);
        recipientBuilder.add(recipients);
    }

    @SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
    public NewMailBuilder setBody(final String body) {
        this.body = body;
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
    public NewMailBuilder setSubject(final String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Sets the total CSPA charge required to send this mail. Defaults to 0.00.
     *
     * This value MUST match the CSPA charge required to send the mail, as
     * provided by a {@link CSPACostRequest}.
     *
     * @param approvedCost the cost in ISK
     * @return this, for chaining
     * @see CSPACostRequest
     */
    @SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
    public NewMailBuilder setApprovedCost(final Double approvedCost) {
        this.approvedCost = approvedCost;
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
    public NewMailBuilder addRecipient(Recipient recipient) {
        recipientBuilder.add(recipient);
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
    public NewMailBuilder addRecipient(Recipient ...recipients) {
        recipientBuilder.add(recipients);
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
    public NewMailBuilder addRecipient(int recipientID, Recipient.Type type) {
        final Recipient recipient = new RecipientImpl(recipientID, type);
        recipientBuilder.add(recipient);
        return this;
    }

    /**
     * Builds the new mail object.
     *
     * @return the new mail
     * @throws IllegalArgumentException if the new mail constraints aren't obeyed
     * @see NewMailBuilder for the constraints
     */
    public NewMail build() {
        NewMail mail = new NewMailImpl(approvedCost, body, recipientBuilder.build(), subject);
        NewMailValidator.validate(mail);

        return mail;
    }

    static class NewMailImpl implements NewMail {
        private final Double approvedCost;
        private final String body;
        private final ImmutableSet<Recipient> recipients;
        private final String subject;

        NewMailImpl(final Double approvedCost, final String body, final ImmutableSet<Recipient> recipients, final String subject) {
            this.approvedCost = approvedCost;
            this.body = body;
            this.recipients = recipients;
            this.subject = subject;
        }

        @Override
        public Optional<Double> getApprovedCost() {
            return Optional.ofNullable(approvedCost);
        }

        @Override
        public String getBody() {
            return body;
        }

        @Override
        public ImmutableSet<Recipient> getRecipients() {
            return recipients;
        }

        @Override
        public String getSubject() {
            return subject;
        }
    }

    static class RecipientImpl implements Recipient {
        private final int ID;
        private final Type type;

        RecipientImpl(
            final int id,
            final Type type
        ) {
            ID = id;
            this.type = type;
        }

        @Override
        public int getID() {
            return ID;
        }

        @Override
        public Type getType() {
            return type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ID, type);
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj instanceof Recipient) {
                final Recipient other = (Recipient) obj;

                return Objects.equals(ID, other.getID())
                    && Objects.equals(type, other.getType());
            }

            return false;
        }
    }
}
