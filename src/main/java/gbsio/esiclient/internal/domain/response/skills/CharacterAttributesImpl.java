package gbsio.esiclient.internal.domain.response.skills;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.skills.CharacterAttributes;

import java.time.ZonedDateTime;
import java.util.Optional;

public class CharacterAttributesImpl implements CharacterAttributes {
    private final ZonedDateTime remapCooldownDate;
    private final Integer bonusRemaps;
    private final ZonedDateTime lastRemapDate;
    private final int charisma;
    private final int intelligence;
    private final int memory;
    private final int perception;
    private final int willpower;

    CharacterAttributesImpl(
        @JsonProperty("accrued_remap_cooldown_date")
        final ZonedDateTime remapCooldownDate,
        @JsonProperty("bonus_remaps")
        final Integer bonusRemaps,
        @JsonProperty("last_remap_date")
        final ZonedDateTime lastRemapDate,
        @JsonProperty(value = "charisma", required = true)
        final int charisma,
        @JsonProperty(value = "intelligence", required = true)
        final int intelligence,
        @JsonProperty(value = "memory", required = true)
        final int memory,
        @JsonProperty(value = "perception", required = true)
        final int perception,
        @JsonProperty(value = "willpower", required = true)
        final int willpower
    ) {
        this.remapCooldownDate = remapCooldownDate;
        this.bonusRemaps = bonusRemaps;
        this.lastRemapDate = lastRemapDate;
        this.charisma = charisma;
        this.intelligence = intelligence;
        this.memory = memory;
        this.perception = perception;
        this.willpower = willpower;
    }

    @Override
    public Optional<ZonedDateTime> getRemapCooldownDate() {
        return Optional.ofNullable(remapCooldownDate);
    }

    @Override
    public Optional<Integer> getBonusRemaps() {
        return Optional.ofNullable(bonusRemaps);
    }

    @Override
    public Optional<ZonedDateTime> getLastRemapDate() {
        return Optional.ofNullable(lastRemapDate);
    }

    @Override
    public int getCharisma() {
        return charisma;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public int getMemory() {
        return memory;
    }

    @Override
    public int getPerception() {
        return perception;
    }

    @Override
    public int getWillpower() {
        return willpower;
    }
}
