package gbsio.esiclient.internal.domain.response.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.mail.MailHeader;
import gbsio.esiclient.api.domain.common.mail.Recipient;

import java.time.ZonedDateTime;
import java.util.Optional;

public class MailHeaderImpl implements MailHeader {
    private final Integer senderCharacterID;
    private final Boolean isRead;
    private final ImmutableList<Integer> labelIDs;
    private final Integer mailID;
    private final ImmutableList<Recipient> recipients;
    private final String subject;
    private final ZonedDateTime date;

    MailHeaderImpl(
        @JsonProperty("from")
        final Integer senderCharacterID,
        @JsonProperty("is_read")
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
        this.senderCharacterID = senderCharacterID;
        this.isRead = isRead;
        this.labelIDs = MoreObjects.firstNonNull(labelIDs, ImmutableList.of());
        this.mailID = mailID;
        this.recipients = MoreObjects.firstNonNull(recipients, ImmutableList.of());
        this.subject = subject;
        this.date = date;
    }

    @Override
    public Optional<Integer> getSenderCharacterID() {
        return Optional.ofNullable(senderCharacterID);
    }

    public Optional<Boolean> isRead() {
        return Optional.ofNullable(isRead);
    }

    @Override
    public ImmutableList<Integer> getLabelIDs() {
        return labelIDs;
    }

    @Override
    public Optional<Integer> getMailID() {
        return Optional.ofNullable(mailID);
    }

    @Override
    public ImmutableList<Recipient> getRecipients() {
        return recipients;
    }

    @Override
    public Optional<String> getSubject() {
        return Optional.ofNullable(subject);
    }

    @Override
    public Optional<ZonedDateTime> getDate() {
        return Optional.ofNullable(date);
    }
}
