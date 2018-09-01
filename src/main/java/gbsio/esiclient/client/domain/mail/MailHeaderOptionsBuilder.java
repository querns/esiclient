package gbsio.esiclient.client.domain.mail;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.mail.MailHeaderOptions;

import java.util.Collection;
import java.util.Optional;

/**
 * Builds options for filtering returned mail headers and pulling older mails.
 */
final public class MailHeaderOptionsBuilder {
    private final ImmutableList.Builder<Integer> labelIDsBuilder = ImmutableList.builder();

    private Integer lastMailID;

    /**
     * Flag the request to only return mails older than the supplied mail ID.
     *
     * @param lastMailID a mail ID
     * @return this, for chaining
     */
    public MailHeaderOptionsBuilder setLastMailID(final Integer lastMailID) {
        this.lastMailID = lastMailID;
        return this;
    }

    /**
     * Restricts the request to only return headers from mails flagged with a
     * given set of label IDs.
     *
     * @param labelID a label ID to restrict the headers returned
     * @return this, for chaining
     */
    public MailHeaderOptionsBuilder addFilterToLabelID(int labelID) {
        labelIDsBuilder.add(labelID);
        return this;
    }

    /**
     * Restricts the request to only return headers from mails flagged with a
     * given set of label IDs.
     *
     * @param labelIDs 1 or more label IDs to restrict the headers returned
     * @return this, for chaining
     */
    public MailHeaderOptionsBuilder addFilterToLabelID(Integer ...labelIDs) {
        labelIDsBuilder.add(labelIDs);
        return this;
    }

    /**
     * Restricts the request to only return headers from mails flagged with a
     * given set of label IDs.
     *
     * @param labelIDs 1 or more label IDs to restrict the headers returned
     * @return this, for chaining
     */
    public MailHeaderOptionsBuilder addFilterToLabelID(Collection<Integer> labelIDs) {
        labelIDsBuilder.addAll(labelIDs);
        return this;
    }

    /**
     * Builds the options object.
     * @return an options object
     */
    public MailHeaderOptions build() {
        return new MailHeaderOptionsImpl(labelIDsBuilder.build(), lastMailID);
    }

    /**
     * Returns an empty options object.
     * @return an options object with no restrictions or history flag
     */
    public static MailHeaderOptions empty() {
        return new MailHeaderOptionsImpl();
    }

    static class MailHeaderOptionsImpl implements MailHeaderOptions {
        private final ImmutableList<Integer> filterToLabelIDs;
        private final Integer lastMailID;

        @SuppressWarnings({"WeakerAccess", "unused"})
        public MailHeaderOptionsImpl(final ImmutableList<Integer> filterToLabelIDs, final Integer lastMailID) {
            this.filterToLabelIDs = MoreObjects.firstNonNull(filterToLabelIDs, ImmutableList.of());
            this.lastMailID = lastMailID;
        }

        @SuppressWarnings({"WeakerAccess", "unused"})
        public MailHeaderOptionsImpl() {
            this(null, null);
        }

        @Override
        public ImmutableList<Integer> getFilterToLabelIDs() {
            return filterToLabelIDs;
        }

        @Override
        public Optional<Integer> getLastMailID() {
            return Optional.ofNullable(lastMailID);
        }
    }
}
