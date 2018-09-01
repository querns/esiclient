package gbsio.esiclient.internal.hooks.request.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.api.config.DataSource;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.internal.hooks.request.QueryBuildingHook;
import org.asynchttpclient.RequestBuilder;

/**
 * Changes the data source for the query, if needed.
 */
@Singleton
public class DataSourceHook implements QueryBuildingHook {
    private final DataSource dataSource;

    @Inject
    DataSourceHook(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void process(final RequestBuilder builder, final Request<?> request) {
        if (DataSource.TRANQUILITY != dataSource) {
            //noinspection SpellCheckingInspection
            builder.addQueryParam("datasource", dataSource.getIdentifier());
        }
    }
}
