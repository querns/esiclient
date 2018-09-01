package gbsio.esiclient.api.config;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.etag.ETagCache;
import gbsio.esiclient.client.etag.NullETagCache;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Configuration data for a {@link gbsio.esiclient.api.Client}.
 *
 * @see ClientConfig#builder()
 */
public interface ClientConfig {
    /**
     * Gets the persistence device for storing information.
     *
     * @return the persistence device
     */
    ETagCache getETagCache();

    /**
     * Gets an executor, used to create all threads.
     *
     * @return an executor
     */
    Executor getExecutor();

    /**
     * Provides a base URL to the ESI server.
     *
     * @return a base URL
     */
    String getESIServer();

    /**
     * Gets which server to pull from.
     *
     * @return the data source
     */
    DataSource getDataSource();

    /**
     * Gets the user agent to send with every request.
     *
     * @return the user agent
     */
    String getUserAgent();

    /**
     * Gets a builder for a client config. <b>NOT THREAD-SAFE!</b>
     *
     * @return the config builder
     */
    static BuilderPhaseOne builder() {
        return new ConfigBuilder() {
            private ETagCache ETagCache;
            private Executor executor;
            private String ESIServer = "https://esi.evetech.net";
            private DataSource dataSource = DataSource.TRANQUILITY;
            private String userAgent;

            @Override
            public BuilderPhaseTwo setUserAgent(final String userAgent) {
                this.userAgent = userAgent;
                return this;
            }

            /**
             * Sets the ETagCache engine to be used by the client.
             * <p>
             * Defaults to {@link NullETagCache}.
             *
             * @param ETagCache a ETagCache engine
             * @return this instance, for chaining
             */
            @SuppressWarnings("unused")
            public BuilderPhaseTwo setETagCache(ETagCache ETagCache) {
                this.ETagCache = ETagCache;

                return this;
            }

            /**
             * Sets the thread executor to be used by the client.
             * <p>
             * An executor with a low, fixed number of threads may cause deadlock,
             * especially when using the low priority client.
             * <p>
             * Defaults to {@link Executors#newCachedThreadPool()}.
             *
             * @param executor a thread executor
             * @return this instance, for chaining
             */
            @SuppressWarnings("unused")
            public BuilderPhaseTwo setExecutor(Executor executor) {
                this.executor = executor;
                return this;
            }

            /**
             * Sets the base URL to the ESI server.
             * <p>
             * Defaults to "https://esi.evetech.net". This method shouldn't need to be
             * used unless the URL changes.
             *
             * @param ESIServer the base URL to ESI
             * @return this instance, for chaining
             */
            @SuppressWarnings("unused")
            public BuilderPhaseTwo setESIServer(final String ESIServer) {
                this.ESIServer = Preconditions.checkNotNull(ESIServer);
                return this;
            }

            /**
             * Sets the data source.
             * <p>
             * Defaults to Tranquility.
             *
             * @param dataSource the new data source
             * @return this instance, for chaining
             */
            @SuppressWarnings("unused")
            public BuilderPhaseTwo setDataSource(final DataSource dataSource) {
                this.dataSource = dataSource;
                return this;
            }

            /**
             * Builds the client config.
             *
             * @return the client config
             */
            public ClientConfig build() {
                return new ClientConfigImpl(ETagCache, executor, ESIServer, dataSource, userAgent);
            }

            class ClientConfigImpl implements ClientConfig {
                private final ETagCache ETagCache;
                private final Executor executor;
                private final String ESIServer;
                private final DataSource dataSource;
                private final String userAgent;

                ClientConfigImpl(final ETagCache ETagCache, final Executor executor, final String ESIServer, final DataSource dataSource, final String userAgent) {
                    this.ESIServer = ESIServer;
                    this.dataSource = dataSource;
                    this.userAgent = userAgent;

                    if (null == ETagCache) {
                        this.ETagCache = new NullETagCache();
                    } else {
                        this.ETagCache = ETagCache;
                    }

                    if (null == executor) {
                        this.executor = Executors.newCachedThreadPool();
                    } else {
                        this.executor = executor;
                    }
                }

                @Override
                public ETagCache getETagCache() {
                    return ETagCache;
                }

                @Override
                public Executor getExecutor() {
                    return executor;
                }

                @Override
                public String getESIServer() {
                    return ESIServer;
                }

                @Override
                public DataSource getDataSource() {
                    return dataSource;
                }

                /**
                 * Gets the user agent to send with every request.
                 *
                 * @return the user agent
                 */
                @Override
                public String getUserAgent() {
                    return userAgent;
                }
            }
        };
    }

    interface BuilderPhaseOne {
        BuilderPhaseTwo setUserAgent(String userAgent);
    }

    interface BuilderPhaseTwo {
        BuilderPhaseTwo setETagCache(ETagCache eTagCache);
        BuilderPhaseTwo setExecutor(Executor executor);
        BuilderPhaseTwo setESIServer(String esiServer);
        BuilderPhaseTwo setDataSource(DataSource dataSource);
        ClientConfig build();
    }
}
