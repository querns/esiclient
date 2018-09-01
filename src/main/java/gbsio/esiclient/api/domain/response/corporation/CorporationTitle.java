package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.CorporationPermissions;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.api.domain.response.common.Title;
import gbsio.esiclient.internal.domain.response.corporations.CorporationTitleImpl;

@JsonDeserialize(as = CorporationTitleImpl.class)
public interface CorporationTitle extends Title, CorporationPermissions {
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
