package gbsio.esiclient.api.domain.response.contracts;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.contracts.OwnedContractImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents information about a contract retrieved by authenticating as a
 * character or corporation.
 */
@JsonDeserialize(as = OwnedContractImpl.class)
public interface OwnedContract extends Contract {
    /**
     * Get the character or corporation that accepted the contract.
     *
     * @return the ID of the accepting char or corp
     */
    int getAcceptorID();

    /**
     * Get the character or corporation ID to whom the contract is assigned.
     *
     * @return the ID of the assignee
     */
    int getAssigneeID();

    /**
     * Get the availability of the contract.
     *
     * This determines who can see and interact with the contract.
     *
     * @return the availability
     */
    Availability getAvailability();

    /**
     * Get the date the contract was accepted.
     *
     * @return the accept date
     */
    Optional<ZonedDateTime> getDateAccepted();

    /**
     * Get the date the contract was completed.
     *
     * This differs from {@link #getDateAccepted()} for courier contracts, as
     * couriers can be accepted and completed at different times.
     *
     * @return the completion date
     */
    Optional<ZonedDateTime> getDateCompleted();


    /**
     * Get the status of the contract.
     *
     * @return the contract status
     */
    Status getStatus();

    /**
     * Get the user-supplied title of the contract.
     *
     * @return the title
     */
    Optional<String> getTitle();

    /**
     * Represents the visibility of a contract.
     */
    enum Availability implements EnumUtil.MappableEnum {
        PUBLIC("public"), PERSONAL("personal"), CORPORATION("corporation"), ALLIANCE("alliance"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, Availability> map = EnumUtil.generateMap(values());

        Availability(String identifier) {
            this.identifier = identifier;
        }

        @Override
        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static Availability of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }

    /**
     * Represents the status of a contract.
     */
    enum Status implements EnumUtil.MappableEnum {
        OUTSTANDING("outstanding"), IN_PROGRESS("in_progress"), FINISHED_ISSUER("finished_issuer"),
        FINISHED_CONTRACTOR("finished_contractor"), FINISHED("finished"), CANCELLED("cancelled"),
        REJECTED("rejected"), FAILED("failed"), DELETED("deleted"), REVERSED("reversed"),
        UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, Status> map = EnumUtil.generateMap(values());

        Status(String identifier) {
            this.identifier = identifier;
        }

        @Override
        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static Status of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }

}
