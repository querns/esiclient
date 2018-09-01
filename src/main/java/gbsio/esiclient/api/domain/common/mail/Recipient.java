package gbsio.esiclient.api.domain.common.mail;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.common.mail.RecipientImpl;

/**
 * Represents information about a recipient of a mail.
 *
 * Implementations MUST implement {@link Object#equals(Object)} and
 * {@link Object#hashCode()}.
 */
@JsonDeserialize(as = RecipientImpl.class)
public interface Recipient {
    /**
     * Gets the ID of the mail recipient.
     *
     * The recipient ID must be married with {@link #getType()} to be properly
     * discovered.
     *
     * @return the recipient's ID
     */
    @JsonGetter("recipient_id")
    int getID();

    /**
     * Gets the type of recipient.
     *
     * @return the recipient type
     */
    @JsonGetter("recipient_type")
    Type getType();

    /**
     * Describes the type of recipient.
     */
    enum Type implements EnumUtil.MappableEnum {
        /** @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo */
        ALLIANCE("alliance"),
        /** @see CharacterInfo */
        CHARACTER("character"),
        /** @see CorporationInfo */
        CORPORATION("corporation"),
        /** @see gbsio.esiclient.api.domain.response.mail.MailingList */
        MAILING_LIST("mailing_list"),
        /** Default value returned when the client doesn't support the recipient type. */
        UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, Type> map = EnumUtil.generateMap(values());

        Type(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static Type of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
