package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.contracts.Contract;

import java.time.ZonedDateTime;
import java.util.Optional;

public class ContractImpl implements Contract {
    private final Double buyout;
    private final Double collateral;
    private final int contractID;
    private final Integer daysToComplete;
    private final Long endLocationID;
    private final ZonedDateTime expirationDate;
    private final ZonedDateTime issueDate;
    private final int issuerCorporationID;
    private final int issuerID;
    private final Double price;
    private final Double reward;
    private final Long startLocationID;
    private final Type type;
    private final Double volume;
    private final boolean isCorpContract;

    ContractImpl(
        @JsonProperty("buyout")
        final Double buyout,
        @JsonProperty("collateral")
        final Double collateral,
        @JsonProperty(value = "contract_id", required = true)
        final int contractID,
        @JsonProperty("days_to_complete")
        final Integer daysToComplete,
        @JsonProperty("end_location_id")
        final Long endLocationID,
        @JsonProperty(value = "date_expired", required = true)
        final ZonedDateTime expirationDate,
        @JsonProperty(value = "date_issued", required = true)
        final ZonedDateTime issueDate,
        @JsonProperty(value = "issuer_corporation_id", required = true)
        final int issuerCorporationID,
        @JsonProperty(value = "issuer_id", required = true)
        final int issuerID,
        @JsonProperty("price")
        final Double price,
        @JsonProperty("reward")
        final Double reward,
        @JsonProperty("start_location_id")
        final Long startLocationID,
        @JsonProperty(value = "type", required = true)
        final Type type,
        @JsonProperty("volume")
        final Double volume,
        @JsonProperty(value = "for_corporation")
        final boolean isCorpContract
    ) {
        this.buyout = buyout;
        this.collateral = collateral;
        this.contractID = contractID;
        this.daysToComplete = daysToComplete;
        this.endLocationID = endLocationID;
        this.expirationDate = expirationDate;
        this.issueDate = issueDate;
        this.issuerCorporationID = issuerCorporationID;
        this.issuerID = issuerID;
        this.price = price;
        this.reward = reward;
        this.startLocationID = startLocationID;
        this.type = type;
        this.volume = volume;
        this.isCorpContract = isCorpContract;
    }

    @Override
    public Optional<Double> getBuyout() {
        return Optional.ofNullable(buyout);
    }

    @Override
    public Optional<Double> getCollateral() {
        return Optional.ofNullable(collateral);
    }

    @Override
    public int getContractID() {
        return contractID;
    }

    @Override
    public Optional<Integer> getDaysToComplete() {
        return Optional.ofNullable(daysToComplete);
    }

    @Override
    public Optional<Long> getEndLocationID() {
        return Optional.ofNullable(endLocationID);
    }

    @Override
    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    @Override
    public ZonedDateTime getIssueDate() {
        return issueDate;
    }

    @Override
    public int getIssuerCorporationID() {
        return issuerCorporationID;
    }

    @Override
    public int getIssuerID() {
        return issuerID;
    }

    @Override
    public Optional<Double> getPrice() {
        return Optional.ofNullable(price);
    }

    @Override
    public Optional<Double> getReward() {
        return Optional.ofNullable(reward);
    }

    @Override
    public Optional<Long> getStartLocationID() {
        return Optional.ofNullable(startLocationID);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public Optional<Double> getVolume() {
        return Optional.ofNullable(volume);
    }

    @Override
    public boolean isCorpContract() {
        return isCorpContract;
    }
}
