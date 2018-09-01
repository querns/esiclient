package gbsio.esiclient.internal.http.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.internal.http.Dispatch;
import gbsio.esiclient.internal.http.RawContentResponse;
import org.javatuples.Pair;

import java.util.concurrent.*;

@Singleton
public class SequentialDispatch implements Dispatch {
    private static final Pair<Request<?>, CompletableFuture<RawContentResponse>> POISON = new Pair<>(null, null);

    private final BlockingQueue<Pair<Request<?>, CompletableFuture<RawContentResponse>>> queue = new LinkedBlockingQueue<>();
    private final Thread thread;

    @Inject
    SequentialDispatch(final ParallelDispatch parallelDispatch) {
        thread = new Thread(() -> {
            Pair<Request<?>, CompletableFuture<RawContentResponse>> pair = null;

            do {
                try {
                    pair = queue.take();
                    pair.getValue1().complete(
                        parallelDispatch.executeSingleRequest(pair.getValue0()).join()
                    );
                } catch (InterruptedException ignored) {
                }
            } while (pair != POISON);
        });
        thread.setDaemon(true);

    }

    public CompletableFuture<RawContentResponse> executeSingleRequest(final Request<?> request) {
        if (Thread.State.NEW == thread.getState()) {
            synchronized (thread) {
                if (Thread.State.NEW == thread.getState()) {
                    thread.start();
                }
            }
        }

        CompletableFuture<RawContentResponse> future = new CompletableFuture<>();

        if (!queue.offer(new Pair<>(request, future))) {
            future.completeExceptionally(new RuntimeException("Unable to offer request to the sequential request queue"));
        }

        return future;
    }

    @SuppressWarnings("unused")
    public void stop() {
        if (!queue.offer(POISON)) {
            throw new RuntimeException("Could not offer poison to the sequential request queue");
        }
    }
}
