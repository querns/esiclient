package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.corporations.ContainerAuditLogImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents an entry in an Audit Log Secure Container (ALSC)'s audit log.
 */
@SuppressWarnings("SpellCheckingInspection")
@JsonDeserialize(as = ContainerAuditLogImpl.class)
public interface ContainerAuditLog {
    /**
     * Gets the action that this entry represents.
     *
     * @return the action
     */
    Action getAction();

    /**
     * Gets the ID of the character that performed this action.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     * @see CharacterInfo
     */
    int getCharacterID();

    /**
     * Returns the unique item ID associated with this container.
     *
     * @return the item ID
     */
    long getContainerID();

    /**
     * Gets the item type ID describing this container.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getContainerTypeID();

    /**
     * Gets the location flag for the container.
     *
     * Location flags describe the location of the item. E.g.: a container in
     * the deliveries hangar will have a flag of "CorpDeliveries."
     *
     * @return the location flag
     */
    String getLocationFlag();

    /**
     * Gets the ID of the location of this container.
     *
     * This refers to a station or structure.
     *
     * @return the ID
     */
    long getLocationID();

    /**
     * Gets the date and time this log entry was created.
     *
     * @return the date and time of entry creation
     */
    ZonedDateTime getDate();

    /**
     * Gets the new config bitmask.
     *
     * This is used to describe how the configuration of a container changes
     * on a CONFIGURE {@link Action}.
     *
     * @return the new bitmask
     */
    Optional<Integer> getNewConfigBitmask();

    /**
     * Gets the old config bitmask.
     *
     * This is used to describe how the configuration of a container changes
     * on a CONFIGURE {@link Action}.
     *
     * @return the old bitmask
     */
    Optional<Integer> getOldConfigBitmask();

    /**
     * Gets the password type being used for this action.
     *
     * Used for ENTER_PASSWORD and SET_PASSWORD actions.
     *
     * @return the password type
     */
    Optional<PasswordType> getPasswordType();

    /**
     * Gets the quantity of the item being acted on.
     *
     * @return the quantity
     */
    Optional<Integer> getQuantity();

    /**
     * Gets the item type ID being acted on.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     */
    Optional<Integer> getItemTypeID();

    /**
     * Describes the type of action being described by this audit log entry.
     */
    enum Action implements EnumUtil.MappableEnum {
        ADD("add"), ASSEMBLE("assemble"), CONFIGURE("configure"), ENTER_PASSWORD("enter_password"),
        LOCK("lock"), MOVE("move"), REPACKAGE("repackage"), SET_NAME("set_name"),
        SET_PASSWORD("set_password"), UNLOCK("unlock"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, Action> map = EnumUtil.generateMap(values());

        Action(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static Action of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }

    /**
     * Describes the type of password being used or modified by this log entry.
     */
    enum PasswordType implements EnumUtil.MappableEnum {
        /**
         * Config passwords are used to configure a container.
         */
        CONFIG("config"),

        /**
         * General passwords are used to access the container.
         */
        GENERAL("general"),

        UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, PasswordType> map = EnumUtil.generateMap(values());

        PasswordType(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static PasswordType of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
