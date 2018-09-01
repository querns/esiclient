package gbsio.esiclient.api.domain.response.wallet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

/**
 * Describes the type of transaction being described in a wallet journal entry.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum RefType implements EnumUtil.MappableEnum {
    ACCELERATION_GATE_FEE("acceleration_gate_fee"), ADVERTISEMENT_LISTING_FEE("advertisement_listing_fee"),
    AGENT_DONATION("agent_donation"), AGENT_LOCATION_SERVICES("agent_location_services"),
    AGENT_MISCELLANEOUS("agent_miscellaneous"), AGENT_MISSION_COLLATERAL_PAID("agent_mission_collateral_paid"),
    AGENT_MISSION_COLLATERAL_REFUNDED("agent_mission_collateral_refunded"), AGENT_MISSION_REWARD("agent_mission_reward"),
    AGENT_MISSION_REWARD_CORPORATION_TAX("agent_mission_reward_corporation_tax"),
    AGENT_MISSION_TIME_BONUS_REWARD("agent_mission_time_bonus_reward"),
    AGENT_MISSION_TIME_BONUS_REWARD_CORPORATION_TAX("agent_mission_time_bonus_reward_corporation_tax"),
    AGENT_SECURITY_SERVICES("agent_security_services"), AGENT_SERVICES_RENDERED("agent_services_rendered"),
    AGENTS_PREWARD("agents_preward"), ALLIANCE_MAINTENANCE_FEE("alliance_maintainance_fee"),
    ALLIANCE_REGISTRATION_FEE("alliance_registration_fee"), ASSET_SAFETY_RECOVERY_TAX("asset_safety_recovery_tax"),
    BOUNTY("bounty"), BOUNTY_PRIZE("bounty_prize"), BOUNTY_PRIZE_CORPORATION_TAX("bounty_prize_corporation_tax"),
    BOUNTY_PRIZES("bounty_prizes"), BOUNTY_REIMBURSEMENT("bounty_reimbursement"), BOUNTY_SURCHARGE("bounty_surcharge"),
    BROKERS_FEE("brokers_fee"), CLONE_ACTIVATION("clone_activation"), CLONE_TRANSFER("clone_transfer"),
    CONTRABAND_FINE("contraband_fine"), CONTRACT_AUCTION_BID("contract_auction_bid"),
    CONTRACT_AUCTION_BID_CORP("contract_auction_bid_corp"), CONTRACT_AUCTION_BID_REFUND("contract_auction_bid_refund"),
    CONTRACT_AUCTION_SOLD("contract_auction_sold"), CONTRACT_BROKERS_FEE("contract_brokers_fee"),
    CONTRACT_BROKERS_FEE_CORP("contract_brokers_fee_corp"), CONTRACT_COLLATERAL("contract_collateral"),
    CONTRACT_COLLATERAL_DEPOSITED_CORP("contract_collateral_deposited_corp"),
    CONTRACT_COLLATERAL_PAYOUT("contract_collateral_payout"), CONTRACT_COLLATERAL_REFUND("contract_collateral_refund"),
    CONTRACT_DEPOSIT("contract_deposit"), CONTRACT_DEPOSIT_CORP("contract_deposit_corp"),
    CONTRACT_DEPOSIT_REFUND("contract_deposit_refund"), CONTRACT_DEPOSIT_SALES_TAX("contract_deposit_sales_tax"),
    CONTRACT_PRICE("contract_price"), CONTRACT_PRICE_PAYMENT_CORP("contract_price_payment_corp"),
    CONTRACT_REVERSAL("contract_reversal"), CONTRACT_REWARD("contract_reward"),
    CONTRACT_REWARD_DEPOSITED("contract_reward_deposited"),
    CONTRACT_REWARD_DEPOSITED_CORP("contract_reward_deposited_corp"), CONTRACT_REWARD_REFUND("contract_reward_refund"),
    CONTRACT_SALES_TAX("contract_sales_tax"), COPYING("copying"), CORPORATE_REWARD_PAYOUT("corporate_reward_payout"),
    CORPORATE_REWARD_TAX("corporate_reward_tax"), CORPORATION_ACCOUNT_WITHDRAWAL("corporation_account_withdrawal"),
    CORPORATION_BULK_PAYMENT("corporation_bulk_payment"), CORPORATION_DIVIDEND_PAYMENT("corporation_dividend_payment"),
    CORPORATION_LIQUIDATION("corporation_liquidation"), CORPORATION_LOGO_CHANGE_COST("corporation_logo_change_cost"),
    CORPORATION_PAYMENT("corporation_payment"), CORPORATION_REGISTRATION_FEE("corporation_registration_fee"),
    COURIER_MISSION_ESCROW("courier_mission_escrow"), CSPA("cspa"), CSPAOFFLINEREFUND("cspaofflinerefund"),
    DATACORE_FEE("datacore_fee"), DNA_MODIFICATION_FEE("dna_modification_fee"), DOCKING_FEE("docking_fee"),
    DUEL_WAGER_ESCROW("duel_wager_escrow"), DUEL_WAGER_PAYMENT("duel_wager_payment"),
    DUEL_WAGER_REFUND("duel_wager_refund"), FACTORY_SLOT_RENTAL_FEE("factory_slot_rental_fee"),
    GM_CASH_TRANSFER("gm_cash_transfer"), INDUSTRY_JOB_TAX("industry_job_tax"),
    INFRASTRUCTURE_HUB_MAINTENANCE("infrastructure_hub_maintenance"), INHERITANCE("inheritance"), INSURANCE("insurance"),
    JUMP_CLONE_ACTIVATION_FEE("jump_clone_activation_fee"), JUMP_CLONE_INSTALLATION_FEE("jump_clone_installation_fee"),
    KILL_RIGHT_FEE("kill_right_fee"), LP_STORE("lp_store"), MANUFACTURING("manufacturing"),
    MARKET_ESCROW("market_escrow"), MARKET_FINE_PAID("market_fine_paid"), MARKET_TRANSACTION("market_transaction"),
    MEDAL_CREATION("medal_creation"), MEDAL_ISSUED("medal_issued"), MISSION_COMPLETION("mission_completion"),
    MISSION_COST("mission_cost"), MISSION_EXPIRATION("mission_expiration"), MISSION_REWARD("mission_reward"),
    OFFICE_RENTAL_FEE("office_rental_fee"), OPERATION_BONUS("operation_bonus"), OPPORTUNITY_REWARD("opportunity_reward"),
    PLANETARY_CONSTRUCTION("planetary_construction"), PLANETARY_EXPORT_TAX("planetary_export_tax"),
    PLANETARY_IMPORT_TAX("planetary_import_tax"), PLAYER_DONATION("player_donation"), PLAYER_TRADING("player_trading"),
    PROJECT_DISCOVERY_REWARD("project_discovery_reward"), PROJECT_DISCOVERY_TAX("project_discovery_tax"),
    REACTION("reaction"), RELEASE_OF_IMPOUNDED_PROPERTY("release_of_impounded_property"), REPAIR_BILL("repair_bill"),
    REPROCESSING_TAX("reprocessing_tax"), RESEARCHING_MATERIAL_PRODUCTIVITY("researching_material_productivity"),
    RESEARCHING_TECHNOLOGY("researching_technology"), RESEARCHING_TIME_PRODUCTIVITY("researching_time_productivity"),
    RESOURCE_WARS_REWARD("resource_wars_reward"), REVERSE_ENGINEERING("reverse_engineering"),
    SECURITY_PROCESSING_FEE("security_processing_fee"), SHARES("shares"), SOVEREIGNTY_BILL("sovereignity_bill"),
    STORE_PURCHASE("store_purchase"), STORE_PURCHASE_REFUND("store_purchase_refund"), TRANSACTION_TAX("transaction_tax"),
    UPKEEP_ADJUSTMENT_FEE("upkeep_adjustment_fee"), WAR_ALLY_CONTRACT("war_ally_contract"), WAR_FEE("war_fee"),
    WAR_FEE_SURRENDER("war_fee_surrender"), UNKNOWN("unknown");

    private final String identifier;
    private static final ImmutableMap<String, RefType> map = EnumUtil.generateMap(values());

    RefType(String identifier) {
        this.identifier = identifier;
    }

    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @JsonCreator
    public static RefType of(String identifier) {
        return map.getOrDefault(identifier, UNKNOWN);
    }
}
