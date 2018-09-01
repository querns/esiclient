package gbsio.esiclient.internal.scheduling;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import gbsio.esiclient.internal.scheduling.impl.ThrottleImpl;

import java.time.Clock;

final public class SchedulingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Throttle.class).to(ThrottleImpl.class);
    }

    @Provides
    Clock provideClock() {
        return Clock.systemUTC();
    }
}
