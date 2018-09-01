package gbsio.esiclient.client.domain.ui;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.ui.PrefilledMail;

import java.util.Optional;

final public class PrefilledMailBuilder {
    private final ImmutableList.Builder<Integer> recipientBuilder = ImmutableList.builder();

    private String body;
    private String subject;
    private Integer corporationOrAllianceRecipientID = null;
    private Integer mailingListRecipientID = null;

    @SuppressWarnings({"WeakerAccess", "unused"})
    public PrefilledMailBuilder(final String body, final String subject, Integer recipient) {
        this(body, subject, ImmutableList.of(recipient));
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public PrefilledMailBuilder(final String body, final String subject, Integer ...recipients) {
        this(body, subject, ImmutableList.<Integer>builder().add(recipients).build());
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public PrefilledMailBuilder(final String body, final String subject, ImmutableList<Integer> recipients) {
        this.body = body;
        this.subject = subject;
        recipientBuilder.addAll(recipients);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public PrefilledMailBuilder(final String body, final String subject) {
        this(body, subject, ImmutableList.of());
    }

    public PrefilledMailBuilder setBody(final String body) {
        this.body = body;
        return this;
    }

    public PrefilledMailBuilder setSubject(final String subject) {
        this.subject = subject;
        return this;
    }

    @SuppressWarnings("unused")
    public PrefilledMailBuilder setCorporationOrAllianceRecipientID(final Integer corporationOrAllianceRecipientID) {
        this.corporationOrAllianceRecipientID = corporationOrAllianceRecipientID;
        return this;
    }

    @SuppressWarnings("unused")
    public PrefilledMailBuilder setMailingListRecipientID(final Integer mailingListRecipientID) {
        this.mailingListRecipientID = mailingListRecipientID;
        return this;
    }

    @SuppressWarnings("unused")
    public PrefilledMailBuilder addRecipient(Integer recipientID) {
        recipientBuilder.add(recipientID);
        return this;
    }

    @SuppressWarnings("unused")
    public PrefilledMailBuilder addRecipient(Integer ...recipientIDs) {
        recipientBuilder.add(recipientIDs);
        return this;
    }

    public PrefilledMail build() {
        return new PrefilledMailImpl(body, recipientBuilder.build(), subject, corporationOrAllianceRecipientID, mailingListRecipientID);
    }

    static class PrefilledMailImpl implements PrefilledMail {
        private final String body;
        private final ImmutableList<Integer> recipients;
        private final String subject;
        private final Integer corporationOrAllianceRecipientID;
        private final Integer mailingListRecipientID;

        PrefilledMailImpl(final String body, final ImmutableList<Integer> recipients, final String subject, final Integer corporationOrAllianceRecipientID, final Integer mailingListRecipientID) {
            this.body = body;
            this.recipients = recipients;
            this.subject = subject;
            this.corporationOrAllianceRecipientID = corporationOrAllianceRecipientID;
            this.mailingListRecipientID = mailingListRecipientID;
        }

        @Override
        public String getBody() {
            return body;
        }

        @Override
        public ImmutableList<Integer> getRecipients() {
            return recipients;
        }

        @Override
        public String getSubject() {
            return subject;
        }

        @Override
        public Optional<Integer> getCorporationOrAllianceRecipientID() {
            return Optional.ofNullable(corporationOrAllianceRecipientID);
        }

        @Override
        public Optional<Integer> getMailingListRecipientID() {
            return Optional.ofNullable(mailingListRecipientID);
        }
    }
}
