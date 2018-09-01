package gbsio.esiclient.internal.response;

import com.google.inject.AbstractModule;
import gbsio.esiclient.internal.response.impl.ResponseProcessorImpl;
import gbsio.esiclient.internal.response.impl.errors.ErrorParserImpl;

public class ResponseModule extends AbstractModule {
    @Override
    protected void configure() {
//        install(new FactoryModuleBuilder()
//            .implement(ResponseProcessor.class, ResponseProcessorImpl.class)
//            .build(ResponseProcessor.Factory.class)
//        );
//        expose(ResponseProcessor.Factory.class);

        bind(ResponseProcessor.class).to(ResponseProcessorImpl.class);
        bind(ErrorParser.class).to(ErrorParserImpl.class);
    }
}
