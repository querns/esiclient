package gbsio.esiclient.internal.domain.response.alliance;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.alliance.AllianceInfo;

import java.time.ZonedDateTime;
import java.util.Optional;

public class AllianceInfoImpl implements AllianceInfo {
    private final int creatorCorporationID;
    private final int creatorCharacterID;
    private final ZonedDateTime creationDate;
    private final String name;
    private final String ticker;

    private final Integer executorCorpID;
    private final Integer factionID;

    AllianceInfoImpl(
        @JsonProperty(value="creator_corporation_id", required=true)
        int creatorCorporationID,
        @JsonProperty(value="creator_id", required=true)
        int creatorCharacterID,
        @JsonProperty(value="date_founded", required=true)
        ZonedDateTime creationDate,
        @JsonProperty(value="name", required=true)
        String name,
        @JsonProperty(value="ticker", required=true)
        String ticker,
        @JsonProperty("executor_corporation_id")
        Integer executorCorpID,
        @JsonProperty("faction_id")
        Integer factionID
    ) {
        this.creatorCorporationID = creatorCorporationID;
        this.creatorCharacterID = creatorCharacterID;
        this.creationDate = creationDate;
        this.name = name;
        this.ticker = ticker;
        this.executorCorpID = executorCorpID;
        this.factionID = factionID;
    }

    @Override
    public int getCreatorCorporationID() {
        return creatorCorporationID;
    }

    @Override
    public int getCreatorCharacterID() {
        return creatorCharacterID;
    }

    @Override
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTicker() {
        return ticker;
    }

    @Override
    public Optional<Integer> getExecutorCorpID() {
        return Optional.ofNullable(executorCorpID);
    }

    @Override
    public Optional<Integer> getFactionID() {
        return Optional.ofNullable(factionID);
    }
}
