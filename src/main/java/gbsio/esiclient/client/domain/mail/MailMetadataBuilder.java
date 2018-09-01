package gbsio.esiclient.client.domain.mail;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.common.mail.MailMetadata;
import gbsio.esiclient.client.validation.mail.MailMetadataValidator;

import java.util.Optional;

/**
 * Creates an options object describing how to change the metadata of a mail.
 *
 * Mail Metadata must abide by the following constraint:
 * <ul>
 *     <li>Mails cannot have more than 25 labels</li>
 * </ul>
 */
final public class MailMetadataBuilder {
    private final ImmutableList.Builder<Integer> labelIDBuilder = ImmutableList.builder();

    private Boolean isRead;

    public MailMetadataBuilder() {
    }

    public MailMetadataBuilder(final Boolean isRead, final ImmutableList<Integer> labelIDs) {
        labelIDBuilder.addAll(labelIDs);
        this.isRead = isRead;
    }

    public MailMetadataBuilder(final Boolean isRead, final Integer ...labelIDs) {
        labelIDBuilder.add(labelIDs);
        this.isRead = isRead;
    }

    public MailMetadataBuilder setIsRead(final Boolean isRead) {
        this.isRead = isRead;
        return this;
    }

    public MailMetadataBuilder addLabelID(int labelID) {
        labelIDBuilder.add(labelID);
        return this;
    }

    public MailMetadataBuilder addLabelID(Integer ...labelIDs) {
        labelIDBuilder.add(labelIDs);
        return this;
    }

    public MailMetadata build() {
        final MailMetadataImpl mailMetadata = new MailMetadataImpl(labelIDBuilder.build(), isRead);
        MailMetadataValidator.validate(mailMetadata);

        return mailMetadata;
    }

    static class MailMetadataImpl implements MailMetadata {
        private final ImmutableList<Integer> labelIDs;
        private final Boolean isRead;

        MailMetadataImpl(final ImmutableList<Integer> labelIDs, final Boolean isRead) {
            this.labelIDs = MoreObjects.firstNonNull(labelIDs, ImmutableList.of());
            this.isRead = isRead;
        }

        public ImmutableList<Integer> getLabelIDs() {
            return labelIDs;
        }

        public Optional<Boolean> isRead() {
            return Optional.ofNullable(isRead);
        }
    }
}
