package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.corporations.RoleHistoryEntryImpl;

import java.time.ZonedDateTime;

/**
 * Represents a change in a corporation member's roles.
 */
@JsonDeserialize(as = RoleHistoryEntryImpl.class)
public interface RoleHistoryEntry {
    /**
     * Get the date that the member's roles changed.
     *
     * @return the date
     */
    ZonedDateTime getChangeDate();

    /**
     * Get the ID of the character whose roles are being changed.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     * @see CharacterInfo
     */
    int getCharacterID();

    /**
     * Get the ID of the character issuing the role changes.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     * @see CharacterInfo
     */
    int getIssuerID();

    /**
     * Get the roles of the member after the change.
     *
     * @return the new roles
     */
    ImmutableList<RoleType> getNewRoles();

    /**
     * Get the roles of the member before the change.
     *
     * @return the old roles
     */
    ImmutableList<RoleType> getOldRoles();

    /**
     * Get the scope of roles that are being modified.
     *
     * @return the role scope
     */
    RoleScope getRoleScope();

    /**
     * Represents the scope that roles apply to.
     */
    enum RoleScope implements EnumUtil.MappableEnum {
        GRANTABLE_ROLES("grantable_roles"), GRANTABLE_ROLES_AT_BASE("grantable_roles_at_base"),
        GRANTABLE_ROLES_AT_HQ("grantable_roles_at_hq"), GRANTABLE_ROLES_AT_OTHER("grantable_roles_at_other"),
        ROLES("roles"), ROLES_AT_BASE("roles_at_base"), ROLES_AT_HQ("roles_at_hq"),
        ROLES_AT_OTHER("roles_at_other"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, RoleScope> map = EnumUtil.generateMap(values());

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        RoleScope(String identifier) {
            this.identifier = identifier;
        }

        @JsonCreator
        public static RoleScope of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
