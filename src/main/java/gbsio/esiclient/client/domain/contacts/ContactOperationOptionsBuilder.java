package gbsio.esiclient.client.domain.contacts;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.request.contacts.ContactOperationOptions;
import gbsio.esiclient.client.validation.contacts.ContactOperationOptionsValidator;

/**
 * Builds options for adding or editing contacts.
 * <p>
 *     The options must be crafted with the following restrictions:
 *     <ul>
 *         <li>There must be at least 1 and no more than 100 contact IDs operated
 *         upon at a time</li>
 *         <li>The number for standings must be between -10 and 10, inclusive</li>
 *     </ul>
 * </p>
 */
final public class ContactOperationOptionsBuilder {
    private final ImmutableSet.Builder<Integer> contactIDsBuilder = ImmutableSet.builder();
    private final ImmutableSet.Builder<Integer> labelIDsBuilder = ImmutableSet.builder();
    private float standing;
    private boolean watchlisted = false;

    /**
     * @param standing a number between -10 and 10 inclusive to be set towards
     *                 contacts
     */
    @SuppressWarnings("unused")
    public ContactOperationOptionsBuilder(final float standing) {
        this.standing = standing;
    }

    /**
     * @param contactIDs 1 or more contact IDs to add or edit
     * @param standing a number between -10 and 10 inclusive to be set towards
     *                 contacts
     */
    @SuppressWarnings("unused")
    public ContactOperationOptionsBuilder(ImmutableList<Integer> contactIDs, final float standing) {
        contactIDsBuilder.addAll(Preconditions.checkNotNull(contactIDs));
    }

    /**
     * Sets the standing number towards the affected contact IDs.
     * @param standing a number between -10 and 10, inclusive
     * @return this, for chaining
     */
    @SuppressWarnings("unused")
    public ContactOperationOptionsBuilder setStanding(final float standing) {
        this.standing = standing;
        return this;
    }

    /**
     * @param watchlisted whether or not to add the contacts to the watch list
     * @return this, for chaining
     */
    @SuppressWarnings("unused")
    public ContactOperationOptionsBuilder setWatchlisted(final boolean watchlisted) {
        this.watchlisted = watchlisted;
        return this;
    }

    /**
     * @param contactID an ID of a character, corporation, or alliance
     * @return this, for chaining
     */
    @SuppressWarnings("unused")
    public ContactOperationOptionsBuilder addContactID(int contactID) {
        this.contactIDsBuilder.add(contactID);
        return this;
    }

    /**
     * @param contactIDs 1 or more IDs of characters, corporations, or alliances
     * @return this, for chaining
     */
    @SuppressWarnings("unused")
    public ContactOperationOptionsBuilder addContactIDs(Integer ...contactIDs) {
        this.contactIDsBuilder.add(contactIDs);
        return this;
    }

    /**
     * Adds labels to the contacts being operated on.
     *
     * For edit operations: all labels previously applied to a contact are
     * erased and replaced with the set of label IDs being applied during the
     * request.
     *
     * @param labelID the ID of a label to apply
     * @return this, for chaining
     */
    @SuppressWarnings("unused")
    public ContactOperationOptionsBuilder addLabelID(int labelID) {
        this.labelIDsBuilder.add(labelID);
        return this;
    }

    /**
     * Adds labels to the contacts being operated on.
     *
     * For edit operations: all labels previously applied to a contact are
     * erased and replaced with the set of label IDs being applied during the
     * request.
     *
     * @param labelIDs 1 or more label IDs to apply to the contacts being
     *                operated upon
     * @return this, for chaining
     */
    @SuppressWarnings("unused")
    public ContactOperationOptionsBuilder addLabelIDs(Integer ...labelIDs) {
        this.labelIDsBuilder.add(labelIDs);
        return this;
    }

    /**
     * Builds the options object.
     *
     * @return an options object
     * @throws IllegalArgumentException if the restrictions aren't obeyed
     * @see ContactOperationOptionsBuilder to see the restrictions
     */
    public ContactOperationOptions build() {
        final ContactOperationOptions contactEdits = new Impl(
            contactIDsBuilder.build(),
            standing,
            labelIDsBuilder.build(),
            watchlisted
        );
        ContactOperationOptionsValidator.validate(contactEdits);
        return contactEdits;
    }

    static class Impl implements ContactOperationOptions {
        private final ImmutableSet<Integer> contactIDsToEdit;
        private final float standing;
        private final ImmutableSet<Integer> labelIDs;
        private final boolean watchlisted;

        Impl(final ImmutableSet<Integer> contactIDsToEdit, final float standing, final ImmutableSet<Integer> labelIDs, final boolean watchlisted) {
            this.contactIDsToEdit = Preconditions.checkNotNull(contactIDsToEdit);
            this.standing = standing;
            this.labelIDs = MoreObjects.firstNonNull(labelIDs, ImmutableSet.of());
            this.watchlisted = watchlisted;
        }

        @Override
        public ImmutableSet<Integer> getContactIDs() {
            return contactIDsToEdit;
        }

        @Override
        public float getStanding() {
            return standing;
        }

        @Override
        public ImmutableSet<Integer> getLabelIDs() {
            return labelIDs;
        }

        @Override
        public boolean isWatchlisted() {
            return watchlisted;
        }
    }
}
