package gbsio.esiclient.internal.scheduling.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.internal.concurrency.AdjustableSemaphore;
import gbsio.esiclient.internal.concurrency.DelayedTaskExecutor;
import gbsio.esiclient.internal.scheduling.ErrorCapacity;
import gbsio.esiclient.internal.scheduling.Throttle;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Singleton
final public class ThrottleImpl implements Throttle {
    // Setting this as a non-static "constant" so it's easy to make a
    // constructor parameter later if needed for testing or whatever
    private final int maxErrorLimit = Constants.MAX_ERROR_LIMIT;

    private final AdjustableSemaphore semaphore = new AdjustableSemaphore();
    // Since we want to set this to a fresh error capacity, and doing so is
    // reliant on clock being set, we'll initialize this in the constructor
    private final AtomicReference<ErrorCapacity> errorCapacity;

    private final DelayedTaskExecutor executor;
    private final Clock clock;

    @Inject
    ThrottleImpl(
        final DelayedTaskExecutor executor,
        final Clock clock
    ) {
        this.executor = executor;
        this.clock = clock;

        semaphore.setMaxPermits(maxErrorLimit);
        errorCapacity = new AtomicReference<>(getRefreshedErrorCapacity());
    }

    @Override
    public void updateErrorCapacity(final ErrorCapacity newCapacity) {
        final ErrorCapacity potentiallyChangedCapacity = errorCapacity.updateAndGet(oldCapacity -> {
            if (!newCapacity.equals(oldCapacity)
                && newCapacity.getGenerationDate().isAfter(oldCapacity.getGenerationDate())) {
                return newCapacity;
            }

            return oldCapacity;
        });

        if (potentiallyChangedCapacity == newCapacity) {
            adjustMaxPermits(newCapacity);
        }
    }

    @Override
    public void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    @Override
    public void release() {
        semaphore.release();
    }

    private void adjustMaxPermits(ErrorCapacity errorCapacity) {
        final int remainingCapacity = errorCapacity.getRemainingCapacity();
        final boolean permitNumberChanged = semaphore.setMaxPermits(remainingCapacity);

        if (permitNumberChanged && remainingCapacity != maxErrorLimit) {
            final ZonedDateTime now = clock.instant().atZone(Constants.TIMEZONE_UTC);
            final ZonedDateTime resetDate = errorCapacity.getResetDate();

            if (resetDate.isAfter(now)) {
                executor.schedule(
                    () -> updateErrorCapacity(getRefreshedErrorCapacity()),
                    now.until(resetDate, ChronoUnit.SECONDS),
                    TimeUnit.SECONDS
                );
            }
        }
    }

    private ErrorCapacity getRefreshedErrorCapacity() {
        return new ErrorCapacityImpl(
            maxErrorLimit,
            clock.instant().atZone(Constants.TIMEZONE_UTC),
            60
        );
    }
}
