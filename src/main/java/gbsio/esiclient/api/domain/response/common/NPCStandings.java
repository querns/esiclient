package gbsio.esiclient.api.domain.response.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.common.NPCStandingsImpl;

/**
 * Represents standings towards an NPC corporation, mission agent, or faction.
 *
 * Standings affect things like NPC police response, mission offers/availability,
 * and discounts for services.
 */
@JsonDeserialize(as = NPCStandingsImpl.class)
public interface NPCStandings {
    /**
     * Get the ID for the NPC these standings are towards.
     *
     * @return the ID
     * @see #getType()
     */
    int getID();

    /**
     * Get the type of NPC these standings are towards.
     * @return the type
     */
    NPCType getType();

    /**
     * Get the standings value towards this NPC.
     *
     * @return a number between -10 and 10, with -10 being terrible and 10
     * being excellent
     */
    float getStanding();

    enum NPCType implements EnumUtil.MappableEnum {
        AGENT("agent"), CORPORATION("npc_corp"), FACTION("faction"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, NPCType> map = EnumUtil.generateMap(values());

        NPCType(String identifier) {
            this.identifier = identifier;
        }

        @Override
        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static NPCType of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
