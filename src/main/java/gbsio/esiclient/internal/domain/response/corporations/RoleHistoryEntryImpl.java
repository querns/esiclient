package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.api.domain.response.corporation.RoleHistoryEntry;

import java.time.ZonedDateTime;

public class RoleHistoryEntryImpl implements RoleHistoryEntry {
    private final ZonedDateTime changeDate;
    private final int characterID;
    private final int issuerID;
    private final ImmutableList<RoleType> newRoles;
    private final ImmutableList<RoleType> oldRoles;
    private final RoleScope roleScope;

    RoleHistoryEntryImpl(
        @JsonProperty(value = "changed_at", required = true)
        final ZonedDateTime changeDate,
        @JsonProperty(value = "character_id", required = true)
        final int characterID,
        @JsonProperty(value = "issuer_id", required = true)
        final int issuerID,
        @JsonProperty(value = "new_roles", required = true)
        final ImmutableList<RoleType> newRoles,
        @JsonProperty(value = "old_roles", required = true)
        final ImmutableList<RoleType> oldRoles,
        @JsonProperty(value = "role_type", required = true)
        final RoleScope roleScope
    ) {
        this.changeDate = changeDate;
        this.characterID = characterID;
        this.issuerID = issuerID;
        this.newRoles = newRoles;
        this.oldRoles = oldRoles;
        this.roleScope = roleScope;
    }

    @Override
    public ZonedDateTime getChangeDate() {
        return changeDate;
    }

    @Override
    public int getCharacterID() {
        return characterID;
    }

    @Override
    public int getIssuerID() {
        return issuerID;
    }

    @Override
    public ImmutableList<RoleType> getNewRoles() {
        return newRoles;
    }

    @Override
    public ImmutableList<RoleType> getOldRoles() {
        return oldRoles;
    }

    @Override
    public RoleScope getRoleScope() {
        return roleScope;
    }
}
