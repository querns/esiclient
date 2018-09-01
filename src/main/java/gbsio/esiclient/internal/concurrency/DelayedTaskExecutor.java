package gbsio.esiclient.internal.concurrency;

import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;

/**
 * Holds a single task to execute after a delay, with the ability to cancel the
 * task.
 */
public interface DelayedTaskExecutor {
    /**
     * Schedules a task to be executed later.
     * <p>
     * Calling this function while a task is currently queued will cause the
     * previous task to be cancelled automatically.
     * <p>
     * No feedback is given to the task if it is cancelled. If the task is
     * currently executing and a request to cancel the task occurs, the task
     * WILL NOT be interrupted.
     *
     * @param runnable the task to run
     * @param delay the time from now to delay execution
     * @param unit the time unit of the delay parameter
     * @throws IllegalArgumentException if {@code runnable} or {@code unit} are null, or if
     * {@code delay} is a negative number
     */
    void schedule(@Nonnull Runnable runnable, long delay, @Nonnull TimeUnit unit);

    /**
     * Cancels the currently running task. Safe to call if no task is running.
     * <p>
     * Tasks are NOT interrupted if a cancellation request occurs while the task
     * is executing.
     */
    void cancelTask();
}
