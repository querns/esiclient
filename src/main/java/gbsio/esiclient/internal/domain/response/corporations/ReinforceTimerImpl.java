package gbsio.esiclient.internal.domain.response.corporations;

import gbsio.esiclient.api.domain.response.corporation.OwnedStructure;

import java.time.ZonedDateTime;
import java.util.Optional;

public class ReinforceTimerImpl implements OwnedStructure.ReinforcementTimer {
    private final ZonedDateTime date;
    private final int hour;
    private final int weekday;

    ReinforceTimerImpl(final ZonedDateTime date, final int hour, final int weekday) {
        this.date = date;
        this.hour = hour;
        this.weekday = weekday;
    }

    ReinforceTimerImpl(final int hour, final int weekday) {
        this.date = null;
        this.hour = hour;
        this.weekday = weekday;
    }

    @Override
    public Optional<ZonedDateTime> getDate() {
        return Optional.ofNullable(date);
    }

    @Override
    public int getHour() {
        return hour;

    }

    @Override
    public int getWeekday() {
        return weekday;
    }
}
