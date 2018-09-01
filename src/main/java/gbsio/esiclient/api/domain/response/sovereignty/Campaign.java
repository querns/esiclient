package gbsio.esiclient.api.domain.response.sovereignty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.sovereignty.CampaignImpl;
import gbsio.esiclient.internal.domain.response.sovereignty.FreeportParticipantImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents an active sovereignty contest.
 */
@JsonDeserialize(as = CampaignImpl.class)
public interface Campaign {
    /**
     * Gets the score earned by attackers.
     *
     * Not present for {@link CampaignType#STATION_FREEPORT station freeport}
     * events.
     *
     * @return the attacker score
     * @see #getType()
     */
    Optional<Float> getAttackerScore();

    /**
     * Gets the unique ID for this campaign.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets the ID of the constellation where the campaign is occurring.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the constellation ID
     * @see gbsio.esiclient.api.domain.response.universe.Constellation
     */
    int getConstellationID();

    /**
     * Gets the ID of the defending alliance.
     *
     * Not present for {@link CampaignType#STATION_FREEPORT station freeport}
     * events.
     *
     * @return the defending alliance ID
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     * @see #getType()
     */
    Optional<Integer> getDefenderID();

    /**
     * Gets the score earned by the defender.
     *
     * Not present for {@link CampaignType#STATION_FREEPORT station freeport}
     * events.
     *
     * @return the defender's score
     * @see #getType()
     */
    Optional<Float> getDefenderScore();

    /**
     * Gets the type of campaign.
     *
     * @return the campaign type
     */
    CampaignType getType();

    /**
     * Gets the list of participants vying for control of a freeport station.
     *
     * Only relevant for {@link CampaignType#STATION_FREEPORT station freeport}
     * events.
     *
     * @return 0 or more freeport participants
     */
    ImmutableList<FreeportParticipant> getFreeportParticipants();

    /**
     * Gets the ID of the solar system whose sovereignty is threatened.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the date that the campaign begins.
     *
     * @return the start date
     */
    ZonedDateTime getStartDate();

    /**
     * Gets the item ID of the structure being contested.
     *
     * @return the item ID
     */
    long getStructureID();

    /**
     * Describes a type of campaign.
     */
    enum CampaignType implements EnumUtil.MappableEnum {
        TCU_DEFENSE("tcu_defense"), IHUB_DEFENSE("ihub_defense"),
        STATION_DEFENSE("station_defense"),
        STATION_FREEPORT("station_freeport"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, CampaignType> map = EnumUtil.generateMap(values());

        CampaignType(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static CampaignType of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }

    /**
     * Represents an alliance vying for control of a freeport station.
     */
    @JsonDeserialize(as = FreeportParticipantImpl.class)
    interface FreeportParticipant {
        /**
         * Gets the alliance ID of the participant.
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return the alliance ID
         * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
         */
        int getAllianceID();

        /**
         * Gets the score earned by the participant.
         *
         * @return the score
         */
        float getScore();
    }
}
