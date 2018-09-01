package gbsio.esiclient.internal.scheduling;

/**
 * Performs rate-limiting actions for the client.
 */
public interface Throttle {
    /**
     * Provides the throttle with new information about remaining error capacity.
     *
     * @param newCapacity the new error capacity
     */
    void updateErrorCapacity(ErrorCapacity newCapacity);

    /**
     * Acquires a permit for executing a request.
     */
    void acquire() throws InterruptedException;

    /**
     * Releases a permit after a request is completed.
     */
    void release();
}
