package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.api.domain.response.corporation.CorporationTitle;

import java.util.Optional;

public class CorporationTitleImpl implements CorporationTitle {
    private final String name;
    private final Integer ID;
    private final ImmutableList<RoleType> roles;
    private final ImmutableList<RoleType> rolesAtBase;
    private final ImmutableList<RoleType> rolesAtHQ;
    private final ImmutableList<RoleType> rolesAtOther;
    private final ImmutableList<RoleType> grantableRoles;
    private final ImmutableList<RoleType> grantableRolesAtBase;
    private final ImmutableList<RoleType> grantableRolesAtHQ;
    private final ImmutableList<RoleType> grantableRolesAtOther;

    CorporationTitleImpl(
        @JsonProperty("name")
        final String name,
        @JsonProperty("title_id")
        final Integer id,
        @JsonProperty("roles")
        final ImmutableList<RoleType> roles,
        @JsonProperty("roles_at_base")
        final ImmutableList<RoleType> rolesAtBase,
        @JsonProperty("roles_at_hq")
        final ImmutableList<RoleType> rolesAtHQ,
        @JsonProperty("roles_at_other")
        final ImmutableList<RoleType> rolesAtOther,
        @JsonProperty("grantable_roles")
        final ImmutableList<RoleType> grantableRoles,
        @JsonProperty("grantable_roles_at_base")
        final ImmutableList<RoleType> grantableRolesAtBase,
        @JsonProperty("grantable_roles_at_hq")
        final ImmutableList<RoleType> grantableRolesAtHQ,
        @JsonProperty("grantable_roles_at_other")
        final ImmutableList<RoleType> grantableRolesAtOther
    ) {
        this.name = name;
        ID = id;
        this.roles = MoreObjects.firstNonNull(roles, ImmutableList.of());
        this.rolesAtBase = MoreObjects.firstNonNull(rolesAtBase, ImmutableList.of());
        this.rolesAtHQ = MoreObjects.firstNonNull(rolesAtHQ, ImmutableList.of());
        this.rolesAtOther = MoreObjects.firstNonNull(rolesAtOther, ImmutableList.of());
        this.grantableRoles = MoreObjects.firstNonNull(grantableRoles, ImmutableList.of());
        this.grantableRolesAtBase = MoreObjects.firstNonNull(grantableRolesAtBase, ImmutableList.of());
        this.grantableRolesAtHQ = MoreObjects.firstNonNull(grantableRolesAtHQ, ImmutableList.of());
        this.grantableRolesAtOther = MoreObjects.firstNonNull(grantableRolesAtOther, ImmutableList.of());
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

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public Optional<Integer> getID() {
        return Optional.ofNullable(ID);
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

    @Override
    public ImmutableList<RoleType> getGrantableRolesAtOther() {
        return grantableRolesAtOther;
    }
}
