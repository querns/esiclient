package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.api.domain.response.corporation.MemberRoles;

public class MemberRolesImpl implements MemberRoles {
    private final int characterID;
    private final ImmutableList<RoleType> grantableRoles;
    private final ImmutableList<RoleType> grantableRolesAtBase;
    private final ImmutableList<RoleType> grantableRolesAtHQ;
    private final ImmutableList<RoleType> grantableRolesAtOther;
    private final ImmutableList<RoleType> roles;
    private final ImmutableList<RoleType> rolesAtBase;
    private final ImmutableList<RoleType> rolesAtHQ;
    private final ImmutableList<RoleType> rolesAtOther;

    MemberRolesImpl(
        @JsonProperty(value = "character_id", required = true)
        final int characterID,
        @JsonProperty("grantable_roles")
        final ImmutableList<RoleType> grantableRoles,
        @JsonProperty("grantable_roles_at_base")
        final ImmutableList<RoleType> grantableRolesAtBase,
        @JsonProperty("grantable_roles_at_hq")
        final ImmutableList<RoleType> grantableRolesAtHQ,
        @JsonProperty("grantable_roles_at_other")
        final ImmutableList<RoleType> grantableRolesAtOther,
        @JsonProperty("roles")
        final ImmutableList<RoleType> roles,
        @JsonProperty("roles_at_base")
        final ImmutableList<RoleType> rolesAtBase,
        @JsonProperty("roles_at_hq")
        final ImmutableList<RoleType> rolesAtHQ,
        @JsonProperty("roles_at_other")
        final ImmutableList<RoleType> rolesAtOther
    ) {
        this.characterID = characterID;
        this.grantableRoles = MoreObjects.firstNonNull(grantableRoles, ImmutableList.of());
        this.grantableRolesAtBase = MoreObjects.firstNonNull(grantableRolesAtBase, ImmutableList.of());
        this.grantableRolesAtHQ = MoreObjects.firstNonNull(grantableRolesAtHQ, ImmutableList.of());
        this.grantableRolesAtOther = MoreObjects.firstNonNull(grantableRolesAtOther, ImmutableList.of());
        this.roles = MoreObjects.firstNonNull(roles, ImmutableList.of());
        this.rolesAtBase = MoreObjects.firstNonNull(rolesAtBase, ImmutableList.of());
        this.rolesAtHQ = MoreObjects.firstNonNull(rolesAtHQ, ImmutableList.of());
        this.rolesAtOther = MoreObjects.firstNonNull(rolesAtOther, ImmutableList.of());
    }

    @Override
    public int getCharacterID() {
        return characterID;
    }

    @Override
    public ImmutableList<RoleType> getGrantableRoles() {
        return grantableRoles;
    }

    @Override
    public ImmutableList<RoleType> getGrantableRolesAtBase() {
        return grantableRolesAtBase;
    }

    @Override
    public ImmutableList<RoleType> getGrantableRolesAtHQ() {
        return grantableRolesAtHQ;
    }

    public ImmutableList<RoleType> getGrantableRolesAtOther() {
        return grantableRolesAtOther;
    }

    @Override
    public ImmutableList<RoleType> getRoles() {
        return roles;
    }

    @Override
    public ImmutableList<RoleType> getRolesAtBase() {
        return rolesAtBase;
    }

    @Override
    public ImmutableList<RoleType> getRolesAtHQ() {
        return rolesAtHQ;
    }

    public ImmutableList<RoleType> getRolesAtOther() {
        return rolesAtOther;
    }
}
