package gbsio.esiclient.api.domain.response.contacts;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.contacts.ContactImpl;

/**
 * Represents the basic contact information common to character, alliance, and
 * corporation contacts.
 */
@JsonDeserialize(as = ContactImpl.class)
public interface BaseContact {
    /**
     * Gets the unique ID for this contact.
     *
     * This ID is used in conjunction with {@link #getContactType()} to
     * determine information about the contact.
     *
     * @return the ID
     */
    int getContactID();

    /**
     * Gets the type of contact.
     *
     * @return the contact type
     */
    ContactType getContactType();

    /**
     * Gets the ID for the label for this contact.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the label ID
     * @see ContactLabel
     */
    ImmutableList<Long> getLabelIDs();

    /**
     * Gets the standings set towards this contact.
     *
     * @return a number between -10 (Terrible) and 10 (Excellent.)
     */
    float getStanding();

    enum ContactType implements EnumUtil.MappableEnum {
        CHARACTER("character"), CORPORATION("corporation"), ALLIANCE("alliance"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, ContactType> map = EnumUtil.generateMap(values());

        ContactType(String identifier) {
            this.identifier = identifier;
        }

        @Override
        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static ContactType of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
