package gbsio.esiclient.internal.hooks;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import gbsio.esiclient.internal.hooks.request.PostQueryHook;
import gbsio.esiclient.internal.hooks.request.QueryBuildingHook;
import gbsio.esiclient.internal.hooks.request.impl.*;
import gbsio.esiclient.internal.hooks.response.HeadersHook;
import gbsio.esiclient.internal.hooks.response.StatusHook;
import gbsio.esiclient.internal.hooks.response.impl.*;

public class HooksModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<HeadersHook> headersHookMultibinder = Multibinder.newSetBinder(binder(), HeadersHook.class);
        Multibinder<StatusHook> statusHookMultibinder = Multibinder.newSetBinder(binder(), StatusHook.class);
        Multibinder<PostQueryHook> postQueryHookMultibinder = Multibinder.newSetBinder(binder(), PostQueryHook.class);
        Multibinder<QueryBuildingHook> queryBuildingHookMultibinder = Multibinder.newSetBinder(binder(), QueryBuildingHook.class);

        headersHookMultibinder.addBinding().to(UpdateThrottle.class);
        headersHookMultibinder.addBinding().to(DeprecationDetectionHook.class);
        headersHookMultibinder.addBinding().to(NewETagHook.class);
        headersHookMultibinder.addBinding().to(ExpirationHook.class);

        statusHookMultibinder.addBinding().to(ErrorStatusHook.class);
        statusHookMultibinder.addBinding().to(NotModifiedHook.class);

        postQueryHookMultibinder.addBinding().to(AppendBodyHook.class);
        postQueryHookMultibinder.addBinding().to(AccessTokenHook.class);
        postQueryHookMultibinder.addBinding().to(AppendETagHook.class);

        queryBuildingHookMultibinder.addBinding().to(I18NHook.class);
        queryBuildingHookMultibinder.addBinding().to(DataSourceHook.class);

    }
}
