package gbsio.esiclient.internal.domain.response.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.common.mail.Recipient;
import gbsio.esiclient.api.domain.response.mail.Mail;
import gbsio.esiclient.api.domain.response.mail.MailHeader;

import java.time.ZonedDateTime;
import java.util.Optional;

public class MailImpl implements Mail {
    private final String body;
    private final MailHeader delegate;

    MailImpl(
        @JsonProperty("body")
        String body,
        @JsonProperty("from")
        final Integer senderCharacterID,
        @JsonProperty("read")
        final Boolean isRead,
        @JsonProperty("labels")
        final ImmutableList<Integer> labelIDs,
        @JsonProperty("mail_id")
        final Integer mailID,
        @JsonProperty("recipients")
        final ImmutableList<Recipient> recipients,
        @JsonProperty("subject")
        final String subject,
        @JsonProperty("timestamp")
        final ZonedDateTime date
    ) {
        this.body = body;
        this.delegate = new MailHeaderImpl(senderCharacterID, isRead, labelIDs, mailID, recipients, subject, date);
    }

    @Override
    public Optional<String> getBody() {
        return Optional.ofNullable(body);
    }

    @Override
    public Optional<Integer> getSenderCharacterID() {
        return delegate.getSenderCharacterID();
    }

    @Override
    public Optional<Boolean> isRead() {
        return delegate.isRead();
    }

    @Override
    public ImmutableList<Integer> getLabelIDs() {
        return delegate.getLabelIDs();
    }

    @Override
    public Optional<Integer> getMailID() {
        return delegate.getMailID();
    }

    @Override
    public ImmutableList<Recipient> getRecipients() {
        return delegate.getRecipients();
    }

    @Override
    public Optional<String> getSubject() {
        return delegate.getSubject();
    }

    @Override
    public Optional<ZonedDateTime> getDate() {
        return delegate.getDate();
    }
}
