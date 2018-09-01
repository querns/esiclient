package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;

import java.time.ZonedDateTime;
import java.util.Optional;

public class CharacterInfoImpl implements CharacterInfo {
    private final int corporationID;
    private final ZonedDateTime birthday;
    private final String name;
    private final Gender gender;
    private final int raceID;
    private final int bloodlineID;
    private final Integer allianceID;
    private final Integer ancestryID;
    private final Integer factionID;
    private final Float securityStatus;
    private final String description;

    CharacterInfoImpl(
        @JsonProperty(value = "corporation_id", required = true)
        final int corporationID,
        @JsonProperty(value = "birthday", required = true)
        final ZonedDateTime birthday,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "gender", required = true)
        final Gender gender,
        @JsonProperty(value = "race_id", required = true)
        final int raceID,
        @JsonProperty(value = "bloodline_id", required = true)
        final int bloodlineID,
        @JsonProperty("alliance_id")
        final Integer allianceID,
        @JsonProperty("ancestry_id")
        final Integer ancestryID,
        @JsonProperty("faction_id")
        final Integer factionID,
        @JsonProperty("security_status")
        final Float securityStatus,
        @JsonProperty("description")
        final String description
    ) {
        this.corporationID = corporationID;
        this.birthday = birthday;
        this.name = name;
        this.gender = gender;
        this.raceID = raceID;
        this.bloodlineID = bloodlineID;
        this.allianceID = allianceID;
        this.ancestryID = ancestryID;
        this.factionID = factionID;
        this.securityStatus = securityStatus;
        this.description = description;
    }

    @Override
    public int getCorporationID() {
        return corporationID;
    }

    @Override
    public ZonedDateTime getBirthday() {
        return birthday;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public int getRaceID() {
        return raceID;
    }

    @Override
    public int getBloodlineID() {
        return bloodlineID;
    }

    @Override
    public Optional<Integer> getAllianceID() {
        return Optional.ofNullable(allianceID);
    }

    @Override
    public Optional<Integer> getAncestryID() {
        return Optional.ofNullable(ancestryID);
    }

    @Override
    public Optional<Integer> getFactionID() {
        return Optional.ofNullable(factionID);
    }

    @Override
    public Optional<Float> getSecurityStatus() {
        return Optional.ofNullable(securityStatus);
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }
}
