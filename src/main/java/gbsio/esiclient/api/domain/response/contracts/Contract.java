package gbsio.esiclient.api.domain.response.contracts;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.contracts.ContractImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents base information for all contracts retrieved via ESI.
 */
@JsonDeserialize(as = ContractImpl.class)
public interface Contract {
    /**
     * Get the buyout price for the contract.
     *
     * Only applicable to auctions.
     *
     * @return the buyout price in ISK
     */
    Optional<Double> getBuyout();

    /**
     * Get the collateral needed to accept this contract.
     *
     * Only applicable to couriers.
     *
     * @return the collateral amount in ISK
     */
    Optional<Double> getCollateral();

    /**
     * Get the unique ID associated with this contract.
     *
     * @return the ID
     */
    int getContractID();

    /**
     * Get the date the contract expires.
     *
     * @return the expiration date
     */
    ZonedDateTime getExpirationDate();

    /**
     * Get the issue date of the contract.
     *
     * @return the issue date
     */
    ZonedDateTime getIssueDate();

    /**
     * Get the character ID of the issuer of the contract.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     * @see CharacterInfo
     */
    int getIssuerID();

    /**
     * Get how many days are allowed to complete this contract.
     *
     * Only applicable to couriers.
     *
     * @return the number of days allowed
     */
    Optional<Integer> getDaysToComplete();

    /**
     * Get the ID of the end location for this contract.
     *
     * Only applicable to couriers.
     *
     * @return the end location ID
     */
    Optional<Long> getEndLocationID();

    /**
     * Get whether or not the contract is issued on behalf of a corporation.
     *
     * @return true if the contract is issued on behalf of a corporation, false
     * if on behalf of a character
     */
    boolean isCorpContract();

    /**
     * Get the corporation ID of the issue.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    int getIssuerCorporationID();

    /**
     * Get the price for this contract.
     *
     * Applicable to item exchange and auction contracts.
     *
     * @return the price in ISK
     */
    Optional<Double> getPrice();

    /**
     * Get the reward for completing this contract.
     *
     * Only applicable to couriers.
     *
     * @return the reward in ISK
     */
    Optional<Double> getReward();

    /**
     * Get the start location ID for this contract.
     *
     * @return the start location ID
     */
    Optional<Long> getStartLocationID();

    /**
     * Get the contract type.
     *
     * @return the type
     */
    Type getType();

    /**
     * Get the volume of items in the contract.
     *
     * @return the volume in m^3
     */
    Optional<Double> getVolume();

    /**
     * Represents the contract type.
     */
    enum Type implements EnumUtil.MappableEnum {
        ITEM_EXCHANGE("item_exchange"), AUCTION("auction"), COURIER("courier"),
        LOAN("loan"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, OwnedContract.Type> map = EnumUtil.generateMap(values());

        Type(String identifier) {
            this.identifier = identifier;
        }

        @Override
        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static Type of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
