package gbsio.esiclient.internal.client;

import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import gbsio.esiclient.api.BaseClient;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.internal.client.impl.BaseClientImpl;
import gbsio.esiclient.internal.client.impl.ClientContainer;
import gbsio.esiclient.internal.http.Dispatch;
import gbsio.esiclient.internal.http.impl.ParallelDispatch;
import gbsio.esiclient.internal.http.impl.SequentialDispatch;

public class ClientInternalsModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new ClientDifferentiationModule(Names.named("Normal")) {
            @Override
            void bindDispatch() {
                bind(Dispatch.class).to(ParallelDispatch.class);
            }
        });

        install(new ClientDifferentiationModule(Names.named("Low Priority")) {
            @Override
            void bindDispatch() {
                bind(Dispatch.class).to(SequentialDispatch.class);
            }
        });

        bind(Client.class).to(ClientContainer.class);
    }

    private abstract class ClientDifferentiationModule extends PrivateModule {
        private final Named annotation;

        ClientDifferentiationModule(final Named annotation) {
            this.annotation = annotation;
        }

        @Override
        protected void configure() {
            bind(BaseClient.class).annotatedWith(annotation).to(BaseClientImpl.class);
            expose(BaseClient.class).annotatedWith(annotation);
            bindDispatch();
        }

        abstract void bindDispatch();
    }
}
