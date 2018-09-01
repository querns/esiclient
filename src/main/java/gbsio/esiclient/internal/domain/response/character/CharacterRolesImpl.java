package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CharacterRoles;
import gbsio.esiclient.api.domain.response.common.RoleType;

public class CharacterRolesImpl implements CharacterRoles {
    private final ImmutableList<RoleType> roles;
    private final ImmutableList<RoleType> rolesAtBase;
    private final ImmutableList<RoleType> rolesAtHQ;
    private final ImmutableList<RoleType> rolesAtOther;

    CharacterRolesImpl(
        @JsonProperty("roles")
        final ImmutableList<RoleType> roles,
        @JsonProperty("roles_at_base")
        final ImmutableList<RoleType> rolesAtBase,
        @JsonProperty("roles_at_hq")
        final ImmutableList<RoleType> rolesAtHQ,
        @JsonProperty("roles_at_other")
        final ImmutableList<RoleType> rolesAtOther
    ) {
        this.roles = MoreObjects.firstNonNull(roles, ImmutableList.of());
        this.rolesAtBase = MoreObjects.firstNonNull(rolesAtBase, ImmutableList.of());
        this.rolesAtHQ = MoreObjects.firstNonNull(rolesAtHQ, ImmutableList.of());
        this.rolesAtOther = MoreObjects.firstNonNull(rolesAtOther, ImmutableList.of());
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

    @Override
    public ImmutableList<RoleType> getRolesAtOther() {
        return rolesAtOther;
    }
}
