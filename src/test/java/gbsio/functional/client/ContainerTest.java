package gbsio.functional.client;

import com.google.inject.Guice;
import com.google.inject.Injector;
import gbsio.esiclient.ClientModule;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.config.ClientConfig;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContainerTest {
    @Test
    void buildContainer() {
        Injector injector = Guice.createInjector(new ClientModule(
            ClientConfig.builder()
                .setUserAgent(FunctionalTestHarness.USER_AGENT)
                .build()
        ));

        final Client client = injector.getInstance(Client.class);

        assertNotNull(client);
    }
}