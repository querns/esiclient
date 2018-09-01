package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.planetaryinteraction.CustomsOffice;

import java.util.Optional;

public class CustomsOfficeImpl implements CustomsOffice {
    private final Float allianceTaxRate;
    private final boolean allowStandingsAccess;
    private final boolean allowAllianceAccess;
    private final Float badStandingsTaxRate;
    private final Float corporationTaxRate;
    private final Float excellentStandingsTaxRate;
    private final Float goodStandingsTaxRate;
    private final Float neutralStandingsTaxRate;
    private final long ID;
    private final int reinforceExitStart;
    private final int reinforceExitEnd;
    private final AllowedStandingLevel allowedStandingLevel;
    private final int solarSystemID;
    private final Float terribleStandingsTaxRate;

    CustomsOfficeImpl(
        @JsonProperty("alliance_tax_rate")
        final Float allianceTaxRate,
        @JsonProperty(value = "allow_access_with_standings", required = true)
        final boolean allowStandingsAccess,
        @JsonProperty(value = "allow_alliance_access", required = true)
        final boolean allowAllianceAccess,
        @JsonProperty("bad_standing_tax_rate")
        final Float badStandingsTaxRate,
        @JsonProperty("corporation_tax_rate")
        final Float corporationTaxRate,
        @JsonProperty("excellent_standing_tax_rate")
        final Float excellentStandingsTaxRate,
        @JsonProperty("good_standing_tax_rate")
        final Float goodStandingsTaxRate,
        @JsonProperty("neutral_standing_tax_rate")
        final Float neutralStandingsTaxRate,
        @JsonProperty(value = "office_id", required = true)
        final long id,
        @JsonProperty(value = "reinforce_exit_start", required = true)
        final int reinforceExitStart,
        @JsonProperty(value = "reinforce_exit_end", required = true)
        final int reinforceExitEnd,
        @JsonProperty("standing_level")
        final AllowedStandingLevel allowedStandingLevel,
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID,
        @JsonProperty("terrible_standing_tax_rate")
        final Float terribleStandingsTaxRate
    ) {
        this.allianceTaxRate = allianceTaxRate;
        this.allowStandingsAccess = allowStandingsAccess;
        this.allowAllianceAccess = allowAllianceAccess;
        this.badStandingsTaxRate = badStandingsTaxRate;
        this.corporationTaxRate = corporationTaxRate;
        this.excellentStandingsTaxRate = excellentStandingsTaxRate;
        this.goodStandingsTaxRate = goodStandingsTaxRate;
        this.neutralStandingsTaxRate = neutralStandingsTaxRate;
        ID = id;
        this.reinforceExitStart = reinforceExitStart;
        this.reinforceExitEnd = reinforceExitEnd;
        this.allowedStandingLevel = allowedStandingLevel;
        this.solarSystemID = solarSystemID;
        this.terribleStandingsTaxRate = terribleStandingsTaxRate;
    }

    @Override
    public Optional<Float> getAllianceTaxRate() {
        return Optional.ofNullable(allianceTaxRate);
    }

    public boolean allowStandingsAccess() {
        return allowStandingsAccess;
    }

    public boolean allowAllianceAccess() {
        return allowAllianceAccess;
    }

    @Override
    public Optional<Float> getBadStandingsTaxRate() {
        return Optional.ofNullable(badStandingsTaxRate);
    }

    @Override
    public Optional<Float> getCorporationTaxRate() {
        return Optional.ofNullable(corporationTaxRate);
    }

    @Override
    public Optional<Float> getExcellentStandingsTaxRate() {
        return Optional.ofNullable(excellentStandingsTaxRate);
    }

    @Override
    public Optional<Float> getGoodStandingsTaxRate() {
        return Optional.ofNullable(goodStandingsTaxRate);
    }

    @Override
    public Optional<Float> getNeutralStandingsTaxRate() {
        return Optional.ofNullable(neutralStandingsTaxRate);
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public int getReinforceExitStart() {
        return reinforceExitStart;
    }

    @Override
    public int getReinforceExitEnd() {
        return reinforceExitEnd;
    }

    @Override
    public AllowedStandingLevel getAllowedStandingLevel() {
        return allowedStandingLevel;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public Optional<Float> getTerribleStandingsTaxRate() {
        return Optional.ofNullable(terribleStandingsTaxRate);
    }
}
