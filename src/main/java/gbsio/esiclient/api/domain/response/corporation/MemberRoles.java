package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.common.CorporationPermissions;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.internal.domain.response.corporations.MemberRolesImpl;

/**
 * Represents the roles granted to a member of a corporation.
 */
@JsonDeserialize(as = MemberRolesImpl.class)
public interface MemberRoles extends CorporationPermissions {
    /**
     * Gets the ID of the character these roles apply to.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     * @see CharacterInfo
     */
    int getCharacterID();

    /**
     * Get roles that may be granted by this character.
     *
     * @return 0 or more grantable roles
     */
    ImmutableList<RoleType> getGrantableRoles();

    /**
     * Get the roles that the character may grant at their base.
     *
     * @return 0 or more grantable roles
     */
    ImmutableList<RoleType> getGrantableRolesAtBase();

    /**
     * Get the roles the character may grant at corporation headquarters.
     *
     * @return 0 or more grantable roles
     */
    ImmutableList<RoleType> getGrantableRolesAtHQ();

    /**
     * Get the roles the character may grant at other locations.
     *
     * @return 0 or more grantable roles
     */
    ImmutableList<RoleType> getGrantableRolesAtOther();

}
