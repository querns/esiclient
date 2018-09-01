package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.contracts.OwnedContract;

import java.time.ZonedDateTime;
import java.util.Optional;

public class OwnedContractImpl implements OwnedContract {
    private final int acceptorID;
    private final int assigneeID;
    private final Availability availability;
    private final Double buyout;
    private final Double collateral;
    private final int contractID;
    private final ZonedDateTime dateAccepted;
    private final ZonedDateTime dateCompleted;
    private final ZonedDateTime expirationDate;
    private final ZonedDateTime issueDate;
    private final Integer daysToComplete;
    private final Long endLocationID;
    private final boolean isCorpContract;
    private final int issuerID;
    private final Double price;
    private final Double reward;
    private final Long startLocationID;
    private final Status status;
    private final String title;
    private final Type type;
    private final Double volume;
    private final int issuerCorporationID;

    OwnedContractImpl(
        @JsonProperty(value = "acceptor_id", required = true)
        final int acceptorID,
        @JsonProperty(value = "assignee_id", required = true)
        final int assigneeID,
        @JsonProperty(value = "availability", required = true)
        final Availability availability,
        @JsonProperty("buyout")
        final Double buyout,
        @JsonProperty("collateral")
        final Double collateral,
        @JsonProperty(value = "contract_id", required = true)
        final int contractID,
        @JsonProperty("date_accepted")
        final ZonedDateTime dateAccepted,
        @JsonProperty("date_completed")
        final ZonedDateTime dateCompleted,
        @JsonProperty(value = "date_expired", required = true)
        final ZonedDateTime expirationDate,
        @JsonProperty(value = "date_issued", required = true)
        final ZonedDateTime issueDate,
        @JsonProperty("days_to_complete")
        final Integer daysToComplete,
        @JsonProperty("end_location_id")
        final Long endLocationID,
        @JsonProperty(value = "for_corporation", required = true)
        final boolean isCorpContract,
        @JsonProperty(value = "issuer_id", required = true)
        final int issuerID,
        @JsonProperty("price")
        final Double price,
        @JsonProperty("reward")
        final Double reward,
        @JsonProperty("start_location_id")
        final Long startLocationID,
        @JsonProperty(value = "status", required = true)
        final Status status,
        @JsonProperty("title")
        final String title,
        @JsonProperty(value = "type", required = true)
        final Type type,
        @JsonProperty("volume")
        final Double volume,
        @JsonProperty(value = "issuer_corporation_id", required = true)
        final int issuerCorporationID
    ) {
        this.acceptorID = acceptorID;
        this.assigneeID = assigneeID;
        this.availability = availability;
        this.buyout = buyout;
        this.collateral = collateral;
        this.contractID = contractID;
        this.dateAccepted = dateAccepted;
        this.dateCompleted = dateCompleted;
        this.expirationDate = expirationDate;
        this.issueDate = issueDate;
        this.daysToComplete = daysToComplete;
        this.endLocationID = endLocationID;
        this.isCorpContract = isCorpContract;
        this.issuerID = issuerID;
        this.price = price;
        this.reward = reward;
        this.startLocationID = startLocationID;
        this.status = status;
        this.title = title;
        this.type = type;
        this.volume = volume;
        this.issuerCorporationID = issuerCorporationID;
    }

    @Override
    public int getAcceptorID() {
        return acceptorID;
    }

    @Override
    public int getAssigneeID() {
        return assigneeID;
    }

    @Override
    public Availability getAvailability() {
        return availability;
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
    public Optional<ZonedDateTime> getDateAccepted() {
        return Optional.ofNullable(dateAccepted);
    }

    @Override
    public Optional<ZonedDateTime> getDateCompleted() {
        return Optional.ofNullable(dateCompleted);
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
    public Optional<Integer> getDaysToComplete() {
        return Optional.ofNullable(daysToComplete);
    }

    @Override
    public Optional<Long> getEndLocationID() {
        return Optional.ofNullable(endLocationID);
    }

    @Override
    public boolean isCorpContract() {
        return isCorpContract;
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
    public Status getStatus() {
        return status;
    }

    @Override
    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public Optional<Double> getVolume() {
        return Optional.ofNullable(volume);
    }

    public int getIssuerCorporationID() {
        return issuerCorporationID;
    }
}
