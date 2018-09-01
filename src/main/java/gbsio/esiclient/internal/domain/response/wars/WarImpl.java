package gbsio.esiclient.internal.domain.response.wars;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.wars.Party;
import gbsio.esiclient.api.domain.response.wars.PrimaryParty;
import gbsio.esiclient.api.domain.response.wars.War;

import java.time.ZonedDateTime;
import java.util.Optional;

public class WarImpl implements War {
    private final PrimaryParty aggressor;
    private final ImmutableList<Party> allies;
    private final ZonedDateTime declarationDate;
    private final PrimaryParty defender;
    private final ZonedDateTime finishDate;
    private final int ID;
    private final boolean mutual;
    private final boolean acceptingAllies;
    private final ZonedDateTime retractDate;
    private final ZonedDateTime startDate;

    WarImpl(
        @JsonProperty(value = "aggressor", required = true)
        final PrimaryParty aggressor,
        @JsonProperty("allies")
        final ImmutableList<Party> allies,
        @JsonProperty(value = "declared", required = true)
        final ZonedDateTime declarationDate,
        @JsonProperty(value = "defender", required = true)
        final PrimaryParty defender,
        @JsonProperty("finished")
        final ZonedDateTime finishDate,
        @JsonProperty(value = "id", required = true)
        final int ID,
        @JsonProperty(value = "mutual", required = true)
        final boolean mutual,
        @JsonProperty(value = "open_for_allies", required = true)
        final boolean acceptingAllies,
        @JsonProperty("retracted")
        final ZonedDateTime retractDate,
        @JsonProperty("started")
        final ZonedDateTime startDate
    ) {
        this.aggressor = aggressor;
        this.allies = MoreObjects.firstNonNull(allies, ImmutableList.of());
        this.declarationDate = declarationDate;
        this.defender = defender;
        this.finishDate = finishDate;
        this.ID = ID;
        this.mutual = mutual;
        this.acceptingAllies = acceptingAllies;
        this.retractDate = retractDate;
        this.startDate = startDate;
    }

    @Override
    public PrimaryParty getAggressor() {
        return aggressor;
    }

    @Override
    public ImmutableList<Party> getAllies() {
        return allies;
    }

    @Override
    public ZonedDateTime getDeclarationDate() {
        return declarationDate;
    }

    @Override
    public PrimaryParty getDefender() {
        return defender;
    }

    @Override
    public Optional<ZonedDateTime> getFinishDate() {
        return Optional.ofNullable(finishDate);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public boolean isMutual() {
        return mutual;
    }

    @Override
    public boolean isAcceptingAllies() {
        return acceptingAllies;
    }

    @Override
    public Optional<ZonedDateTime> getRetractDate() {
        return Optional.ofNullable(retractDate);
    }

    @Override
    public Optional<ZonedDateTime> getStartDate() {
        return Optional.ofNullable(startDate);
    }
}
