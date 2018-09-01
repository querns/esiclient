package gbsio.esiclient.internal.domain.response.sovereignty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Campaign;

import java.time.ZonedDateTime;
import java.util.Optional;

public class CampaignImpl implements Campaign {
    private final Float attackerScore;
    private final int ID;
    private final int constellationID;
    private final Integer defenderID;
    private final Float defenderScore;
    private final CampaignType type;
    private final ImmutableList<FreeportParticipant> freeportParticipants;
    private final int solarSystemID;
    private final ZonedDateTime startDate;
    private final long structureID;

    CampaignImpl(
        @JsonProperty("attackers_score")
        final Float attackerScore,
        @JsonProperty(value = "campaign_id", required = true)
        final int id,
        @JsonProperty(value = "constellation_id", required = true)
        final int constellationID,
        @JsonProperty("defender_id")
        final Integer defenderID,
        @JsonProperty("defender_score")
        final Float defenderScore,
        @JsonProperty(value = "event_type", required = true)
        final CampaignType type,
        @JsonProperty("participants")
        final ImmutableList<FreeportParticipant> freeportParticipants,
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "start_time", required = true)
        final ZonedDateTime startDate,
        @JsonProperty(value = "structure_id", required = true)
        final long structureID
    ) {
        this.attackerScore = attackerScore;
        ID = id;
        this.constellationID = constellationID;
        this.defenderID = defenderID;
        this.defenderScore = defenderScore;
        this.type = type;
        this.freeportParticipants = MoreObjects.firstNonNull(freeportParticipants, ImmutableList.of());
        this.solarSystemID = solarSystemID;
        this.startDate = startDate;
        this.structureID = structureID;
    }

    @Override
    public Optional<Float> getAttackerScore() {
        return Optional.ofNullable(attackerScore);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getConstellationID() {
        return constellationID;
    }

    @Override
    public Optional<Integer> getDefenderID() {
        return Optional.ofNullable(defenderID);
    }

    @Override
    public Optional<Float> getDefenderScore() {
        return Optional.ofNullable(defenderScore);
    }

    @Override
    public CampaignType getType() {
        return type;
    }

    @Override
    public ImmutableList<FreeportParticipant> getFreeportParticipants() {
        return freeportParticipants;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public ZonedDateTime getStartDate() {
        return startDate;
    }

    @Override
    public long getStructureID() {
        return structureID;
    }
}
