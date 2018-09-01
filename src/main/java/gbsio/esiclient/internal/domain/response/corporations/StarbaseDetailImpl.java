package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.StarbaseDetail;

import java.util.Optional;

public class StarbaseDetailImpl implements StarbaseDetail {
    private final boolean allianceMembersAllowed;
    private final boolean corporationMembersAllowed;
    private final StarbaseConfigurer anchorPermission;
    private final boolean willAttackAtWar;
    private final boolean willAttackOnSecurityStatusDrop;
    private final Float attackSecurityStatusThreshold;
    private final Float attackStandingsThreshold;
    private final StarbaseConfigurer fuelBayTakePermission;
    private final StarbaseConfigurer fuelBayViewPermission;
    private final ImmutableList<Fuel> fuels;
    private final StarbaseConfigurer offlinePermission;
    private final StarbaseConfigurer onlinePermission;
    private final StarbaseConfigurer unanchorPermission;
    private final boolean willUseAllianceStandings;

    StarbaseDetailImpl(
        @JsonProperty(value = "allow_alliance_members", required = true)
        final boolean allianceMembersAllowed,
        @JsonProperty(value = "allow_corporation_members", required = true)
        final boolean corporationMembersAllowed,
        @JsonProperty(value = "anchor", required = true)
        final StarbaseConfigurer anchorPermission,
        @JsonProperty(value = "attack_if_at_war", required = true)
        final boolean willAttackAtWar,
        @JsonProperty(value = "attack_if_other_security_status_dropping", required = true)
        final boolean willAttackOnSecurityStatusDrop,
        @JsonProperty("attack_security_status_threshold")
        final Float attackSecurityStatusThreshold,
        @JsonProperty("attack_standing_threshold")
        final Float attackStandingsThreshold,
        @JsonProperty(value = "fuel_bay_take", required = true)
        final StarbaseConfigurer fuelBayTakePermission,
        @JsonProperty(value = "fuel_bay_view", required = true)
        final StarbaseConfigurer fuelBayViewPermission,
        @JsonProperty("fuels")
        final ImmutableList<Fuel> fuels,
        @JsonProperty(value = "offline", required = true)
        final StarbaseConfigurer offlinePermission,
        @JsonProperty(value = "online", required = true)
        final StarbaseConfigurer onlinePermission,
        @JsonProperty(value = "unanchor", required = true)
        final StarbaseConfigurer unanchorPermission,
        @JsonProperty(value = "use_alliance_standings", required = true)
        final boolean willUseAllianceStandings
    ) {
        this.allianceMembersAllowed = allianceMembersAllowed;
        this.corporationMembersAllowed = corporationMembersAllowed;
        this.anchorPermission = anchorPermission;
        this.willAttackAtWar = willAttackAtWar;
        this.willAttackOnSecurityStatusDrop = willAttackOnSecurityStatusDrop;
        this.attackSecurityStatusThreshold = attackSecurityStatusThreshold;
        this.attackStandingsThreshold = attackStandingsThreshold;
        this.fuelBayTakePermission = fuelBayTakePermission;
        this.fuelBayViewPermission = fuelBayViewPermission;
        this.fuels = MoreObjects.firstNonNull(fuels, ImmutableList.of());
        this.offlinePermission = offlinePermission;
        this.onlinePermission = onlinePermission;
        this.unanchorPermission = unanchorPermission;
        this.willUseAllianceStandings = willUseAllianceStandings;
    }

    @Override
    public boolean areAllianceMembersAllowed() {
        return allianceMembersAllowed;
    }

    @Override
    public boolean areCorporationMembersAllowed() {
        return corporationMembersAllowed;
    }

    @Override
    public StarbaseConfigurer getAnchorPermission() {
        return anchorPermission;
    }

    @Override
    public boolean willAttackAtWar() {
        return willAttackAtWar;
    }

    @Override
    public boolean willAttackOnSecurityStatusDrop() {
        return willAttackOnSecurityStatusDrop;
    }

    @Override
    public Optional<Float> getAttackSecurityStatusThreshold() {
        return Optional.ofNullable(attackSecurityStatusThreshold);
    }

    @Override
    public Optional<Float> getAttackStandingsThreshold() {
        return Optional.ofNullable(attackStandingsThreshold);
    }

    @Override
    public StarbaseConfigurer getFuelBayTakePermission() {
        return fuelBayTakePermission;
    }

    @Override
    public StarbaseConfigurer getFuelBayViewPermission() {
        return fuelBayViewPermission;
    }

    @Override
    public ImmutableList<Fuel> getFuels() {
        return fuels;
    }

    @Override
    public StarbaseConfigurer getOfflinePermission() {
        return offlinePermission;
    }

    @Override
    public StarbaseConfigurer getOnlinePermission() {
        return onlinePermission;
    }

    @Override
    public StarbaseConfigurer getUnanchorPermission() {
        return unanchorPermission;
    }

    @Override
    public boolean willUseAllianceStandings() {
        return willUseAllianceStandings;
    }
}
