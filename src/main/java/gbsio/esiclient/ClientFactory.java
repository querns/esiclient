package gbsio.esiclient;

import com.google.inject.Guice;
import com.google.inject.Injector;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.config.ClientConfig;

/**
 * Instantiates a {@link Client}.
 * <p>
 * One of two entry points for the ESI Client. Use this class to instantiate a
 * {@link Client} if you're not using an {@link Injector}.
 */
@SuppressWarnings("unused")
public class ClientFactory {
    private ClientFactory() {}

    /**
     * Creates a client instance.
     * @param config the config to use for the client
     * @return a client
     * @see ClientConfig#builder()
     */
    @SuppressWarnings("unused")
    public static Client instance(ClientConfig config) {
        return Guice.createInjector(new ClientModule(config)).getInstance(Client.class);
    }
}
