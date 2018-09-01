package gbsio.esiclient.internal.http;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import gbsio.esiclient.internal.http.impl.*;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.AsyncHttpClient;

/**
 * Contains classes for interfacing with an {@link org.asynchttpclient.AsyncHttpClient}.
 */
final public class HttpModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(QueryMapConverter.class).to(QueryMapConverterImpl.class);
        bind(AsyncHttpClient.class).toProvider(AsyncHttpClientProvider.class);
        bind(ETagProcessor.class).to(ETagProcessorImpl.class);
        bind(AsyncHttpRequestFactory.class).to(AsyncHttpRequestFactoryImpl.class);
        bind(new TypeLiteral<AsyncHandler<RawContentResponse>>() {}).to(AsyncHandlerImpl.class);

        bind(Dispatch.class).annotatedWith(Names.named("Parallel")).to(ParallelDispatch.class);
        bind(Dispatch.class).annotatedWith(Names.named("Sequential")).to(SequentialDispatch.class);
    }
}
