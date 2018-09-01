package gbsio.esiclient.api.domain.response.contacts;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.contacts.ContactLabelImpl;

/**
 * Represents a label for a contact.
 */
@JsonDeserialize(as = ContactLabelImpl.class)
public interface ContactLabel {
    /**
     * Get the unique ID for this contact label.
     *
     * @return the ID
     */
    long getID();

    /**
     * Get the name for this label.
     *
     * @return the name
     */
    String getName();
}
