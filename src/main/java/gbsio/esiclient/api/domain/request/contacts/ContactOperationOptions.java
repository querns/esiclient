package gbsio.esiclient.api.domain.request.contacts;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.Optional;

public interface ContactOperationOptions {
    /**
     * Gets the IDs of characters, corporations, or alliances (contact IDs) to
     * operate upon.
     *
     * @return 1 to 100 contact IDs
     */
    ImmutableSet<Integer> getContactIDs();

    /**
     * Gets the standing to be set to all of the contact IDs.
     *
     * @return a standing between -10 to 10
     */
    float getStanding();

    /**
     * Gets IDs of labels to apply to the contacts.
     *
     * @return 0 or more label IDs
     */
    ImmutableSet<Integer> getLabelIDs();

    /**
     * Gets whether or not the contacts should be watchlisted.
     *
     * Only effective on contacts that are characters.
     *
     * @return true if the contacts should be watchlisted
     */
    boolean isWatchlisted();

    default ImmutableMap<String, Object> createQueryParameters() {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        builder.put("standing", getStanding());
        builder.put("watched", isWatchlisted());

        if (getLabelIDs().size() > 0) {
            builder.put("label_ids", getLabelIDs());
        }

        return builder.build();
    }

    default Optional<Object> getRequestBody() {
        return Optional.of(getContactIDs());
    }
}
