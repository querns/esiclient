package gbsio.esiclient.api.domain.response.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

/**
 * Represents a role granted to a member of a corporation.
 */
public enum RoleType implements EnumUtil.MappableEnum {
    ACCOUNT_TAKE_1("Account_Take_1"), ACCOUNT_TAKE_2("Account_Take_2"),
    ACCOUNT_TAKE_3("Account_Take_3"), ACCOUNT_TAKE_4("Account_Take_4"),
    ACCOUNT_TAKE_5("Account_Take_5"), ACCOUNT_TAKE_6("Account_Take_6"),
    ACCOUNT_TAKE_7("Account_Take_7"), ACCOUNTANT("Accountant"),
    AUDITOR("Auditor"), COMMUNICATIONS_OFFICER("Communications_Officer"),
    CONFIG_EQUIPMENT("Config_Equipment"), CONFIG_STARBASE_EQUIPMENT("Config_Starbase_Equipment"),
    CONTAINER_TAKE_1("Container_Take_1"), CONTAINER_TAKE_2("Container_Take_2"),
    CONTAINER_TAKE_3("Container_Take_3"), CONTAINER_TAKE_4("Container_Take_4"),
    CONTAINER_TAKE_5("Container_Take_5"), CONTAINER_TAKE_6("Container_Take_6"),
    CONTAINER_TAKE_7("Container_Take_7"), CONTRACT_MANAGER("Contract_Manager"),
    DIPLOMAT("Diplomat"), DIRECTOR("Director"), FACTORY_MANAGER("Factory_Manager"),
    FITTING_MANAGER("Fitting_Manager"), HANGAR_QUERY_1("Hangar_Query_1"),
    HANGAR_QUERY_2("Hangar_Query_2"), HANGAR_QUERY_3("Hangar_Query_3"),
    HANGAR_QUERY_4("Hangar_Query_4"), HANGAR_QUERY_5("Hangar_Query_5"),
    HANGAR_QUERY_6("Hangar_Query_6"), HANGAR_QUERY_7("Hangar_Query_7"),
    HANGAR_TAKE_1("Hangar_Take_1"), HANGAR_TAKE_2("Hangar_Take_2"),
    HANGAR_TAKE_3("Hangar_Take_3"), HANGAR_TAKE_4("Hangar_Take_4"),
    HANGAR_TAKE_5("Hangar_Take_5"), HANGAR_TAKE_6("Hangar_Take_6"),
    HANGAR_TAKE_7("Hangar_Take_7"), JUNIOR_ACCOUNTANT("Junior_Accountant"),
    PERSONNEL_MANAGER("Personnel_Manager"), RENT_FACTORY_FACILITY("Rent_Factory_Facility"),
    RENT_OFFICE("Rent_Office"), RENT_RESEARCH_FACILITY("Rent_Research_Facility"),
    SECURITY_OFFICER("Security_Officer"), STARBASE_DEFENSE_OPERATOR("Starbase_Defense_Operator"),
    STARBASE_FUEL_TECHNICIAN("Starbase_Fuel_Technician"), STATION_MANAGER("Station_Manager"),
    TERRESTRIAL_COMBAT_OFFICER("Terrestrial_Combat_Officer"), TERRESTRIAL_LOGISTICS_OFFICER("Terrestrial_Logistics_Officer"),
    TRADER("Trader"), UNKNOWN("unknown");

    private final String identifier;
    private static final ImmutableMap<String, RoleType> map = EnumUtil.generateMap(values());

    @Override
    @JsonGetter
    public String getIdentifier() {
        return identifier;
    }

    RoleType(String identifier) {
        this.identifier = identifier;
    }

    @JsonCreator
    public static RoleType of(String identifier) {
        return map.getOrDefault(identifier, UNKNOWN);
    }
}
