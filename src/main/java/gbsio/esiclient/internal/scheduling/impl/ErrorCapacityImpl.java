package gbsio.esiclient.internal.scheduling.impl;

import gbsio.esiclient.internal.scheduling.ErrorCapacity;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

final public class ErrorCapacityImpl implements ErrorCapacity {
    private final int remainingCapacity;
    private final ZonedDateTime generationDate;
    private final int secondsUntilCapacityReset;
    private final ZonedDateTime resetDate;

    public ErrorCapacityImpl(int remainingCapacity, ZonedDateTime generationDate, int secondsUntilCapacityReset) {
        this.remainingCapacity = remainingCapacity;
        this.generationDate = generationDate;
        this.secondsUntilCapacityReset = secondsUntilCapacityReset;

        resetDate = getGenerationDate().plus(secondsUntilCapacityReset, ChronoUnit.SECONDS);
    }

    @Override
    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    @Override
    public ZonedDateTime getGenerationDate() {
        return generationDate;
    }

    @Override
    public ZonedDateTime getResetDate() {
        return resetDate;
    }

    @Override
    public int getSecondsUntilCapacityReset() {
        return secondsUntilCapacityReset;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ErrorCapacityImpl) {
            return ((ErrorCapacityImpl) obj).remainingCapacity == remainingCapacity
                && ((ErrorCapacityImpl) obj).resetDate.equals(resetDate);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(remainingCapacity, resetDate);
    }
}
