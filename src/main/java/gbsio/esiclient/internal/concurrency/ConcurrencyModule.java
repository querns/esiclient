package gbsio.esiclient.internal.concurrency;

import com.google.inject.AbstractModule;
import gbsio.esiclient.internal.concurrency.impl.DelayedTaskExecutorImpl;

public class ConcurrencyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DelayedTaskExecutor.class).to(DelayedTaskExecutorImpl.class);
    }
}
