package gbsio.esiclient.internal.concurrency.impl;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import gbsio.esiclient.internal.concurrency.DelayedTaskExecutor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class DelayedTaskExecutorImpl implements DelayedTaskExecutor {
    private final AtomicReference<ScheduledFuture<?>> storedFuture = new AtomicReference<>();
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Inject
    DelayedTaskExecutorImpl() {
    }

    @Override
    public void schedule(@Nonnull final Runnable runnable, final long delay, @Nonnull final TimeUnit unit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(unit);
        Preconditions.checkArgument(delay >= 0, "Delay must be non-negative");

        adjustTask(executorService.schedule(runnable, delay, unit));
    }

    @Override
    public void cancelTask() {
        adjustTask(null);
    }

    private void adjustTask(@Nullable final ScheduledFuture<?> scheduledFuture) {
        final ScheduledFuture<?> oldTask = storedFuture.getAndSet(scheduledFuture);

        if (null != oldTask && !oldTask.isDone()) {
            oldTask.cancel(false);
        }
    }
}
