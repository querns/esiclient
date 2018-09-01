package gbsio.esiclient.internal.domain.response.killmails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.killmails.Attacker;
import gbsio.esiclient.api.domain.response.killmails.Killmail;
import gbsio.esiclient.api.domain.response.killmails.Victim;

import java.time.ZonedDateTime;
import java.util.Optional;

public class KillmailImpl implements Killmail {
    private final ImmutableList<Attacker> attackers;
    private final int ID;
    private final ZonedDateTime date;
    private final Integer moonID;
    private final Victim victim;
    private final Integer warID;
    private final int solarSystemID;

    KillmailImpl(
        @JsonProperty(value = "attackers", required = true) final ImmutableList<Attacker> attackers,
        @JsonProperty(value = "killmail_id", required = true) final int id,
        @JsonProperty(value = "killmail_time", required = true) final ZonedDateTime date,
        @JsonProperty("moon_id") final Integer moonID,
        @JsonProperty(value = "victim", required = true) final Victim victim,
        @JsonProperty("war_id") final Integer warID,
        @JsonProperty(value = "solar_system_id", required = true) final int solarSystemID
    ) {
        this.attackers = MoreObjects.firstNonNull(attackers, ImmutableList.of());
        ID = id;
        this.date = date;
        this.moonID = moonID;
        this.victim = victim;
        this.warID = warID;
        this.solarSystemID = solarSystemID;
    }

    @Override
    public ImmutableList<Attacker> getAttackers() {
        return attackers;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public ZonedDateTime getDate() {
        return date;
    }

    @Override
    public Optional<Integer> getMoonID() {
        return Optional.ofNullable(moonID);
    }

    @Override
    public Victim getVictim() {
        return victim;
    }

    @Override
    public Optional<Integer> getWarID() {
        return Optional.ofNullable(warID);
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }
}
