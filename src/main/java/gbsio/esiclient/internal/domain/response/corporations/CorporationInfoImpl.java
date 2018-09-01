package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;

import java.time.ZonedDateTime;
import java.util.Optional;

public class CorporationInfoImpl implements CorporationInfo {
    private final Integer allianceID;
    private final int ceoID;
    private final int creatorID;
    private final ZonedDateTime foundingDate;
    private final String description;
    private final Integer factionID;
    private final Integer homeStationID;
    private final int memberCount;
    private final String name;
    private final Integer shares;
    private final float taxRate;
    private final String ticker;
    private final String url;

    CorporationInfoImpl(
        @JsonProperty("alliance_id")
        final Integer allianceID,
        @JsonProperty(value = "ceo_id", required = true)
        final int ceoID,
        @JsonProperty(value = "creator_id", required = true)
        final int creatorID,
        @JsonProperty("date_founded")
        final ZonedDateTime foundingDate,
        @JsonProperty("description")
        final String description,
        @JsonProperty("faction_id")
        final Integer factionID,
        @JsonProperty("home_station_id")
        final Integer homeStationID,
        @JsonProperty(value = "member_count", required = true)
        final int memberCount,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty("shares")
        final Integer shares,
        @JsonProperty(value = "tax_rate", required = true)
        final float taxRate,
        @JsonProperty("ticker")
        final String ticker,
        @JsonProperty("url")
        final String url
    ) {
        this.allianceID = allianceID;
        this.ceoID = ceoID;
        this.creatorID = creatorID;
        this.foundingDate = foundingDate;
        this.description = description;
        this.factionID = factionID;
        this.homeStationID = homeStationID;
        this.memberCount = memberCount;
        this.name = name;
        this.shares = shares;
        this.taxRate = taxRate;
        this.ticker = ticker;
        this.url = url;
    }

    @Override
    public Optional<Integer> getAllianceID() {
        return Optional.ofNullable(allianceID);
    }

    @Override
    public int getCeoID() {
        return ceoID;
    }

    @Override
    public int getCreatorID() {
        return creatorID;
    }

    @Override
    public Optional<ZonedDateTime> getFoundingDate() {
        return Optional.ofNullable(foundingDate);
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Override
    public Optional<Integer> getFactionID() {
        return Optional.ofNullable(factionID);
    }

    @Override
    public Optional<Integer> getHomeStationID() {
        return Optional.ofNullable(homeStationID);
    }

    @Override
    public int getMemberCount() {
        return memberCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<Integer> getShares() {
        return Optional.ofNullable(shares);
    }

    @Override
    public float getTaxRate() {
        return taxRate;
    }

    @Override
    public String getTicker() {
        return ticker;
    }

    public Optional<String> getURL() {
        return Optional.ofNullable(url);
    }
}
