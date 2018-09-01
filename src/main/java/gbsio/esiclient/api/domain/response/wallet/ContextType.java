package gbsio.esiclient.api.domain.response.wallet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

/**
 * Assists with resolving the {@link JournalEntry#getContextID() context ID} of
 * a wallet journal entry.
 */
public enum ContextType implements EnumUtil.MappableEnum {
    STRUCTURE_ID("structure_id"), STATION_ID("station_id"),
    MARKET_TRANSACTION_ID("market_transaction_id"),
    CHARACTER_ID("character_id"), CORPORATION_ID("corporation_id"),
    ALLIANCE_ID("alliance_id"), EVE_SYSTEM("eve_system"),
    INDUSTRY_JOB_ID("industry_job_id"), CONTRACT_ID("contract_id"),
    PLANET_ID("planet_id"), SYSTEM_ID("system_id"),
    TYPE_ID("type_id"), UNKNOWN("unknown");

    private final String identifier;
    private static final ImmutableMap<String, ContextType> map = EnumUtil.generateMap(values());

    ContextType(String identifier) {
        this.identifier = identifier;
    }

    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @JsonCreator
    public static ContextType of(String identifier) {
        return map.getOrDefault(identifier, UNKNOWN);
    }
}
