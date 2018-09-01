package gbsio.esiclient.api.domain.response.common;

import com.google.common.collect.ImmutableList;

/**
 * Represents permissions for corporation-specific tasks, information, or
 * management actions. Used by roles and titles to delegate power.
 */
public interface CorporationPermissions {
    /**
     * Get the character's roles.
     *
     * @return 0 or more roles
     */
    ImmutableList<RoleType> getRoles();

    /**
     * Get the roles the character has at the corporation's base.
     *
     * @return 0 or more roles
     */
    ImmutableList<RoleType> getRolesAtBase();

    /**
     * Get the roles the character has at the corporation's HQ.
     *
     * @return 0 or more roles
     */
    ImmutableList<RoleType> getRolesAtHQ();

    /**
     * Get the roles the character has at other locations.
     *
     * @return 0 or more roles
     */
    ImmutableList<RoleType> getRolesAtOther();
}
