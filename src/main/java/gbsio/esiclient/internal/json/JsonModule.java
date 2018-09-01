package gbsio.esiclient.internal.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import gbsio.esiclient.internal.json.impl.JsonParserImpl;
import gbsio.esiclient.internal.json.impl.ObjectMapperProvider;

public class JsonModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(JsonParser.class).to(JsonParserImpl.class);

        bind(ObjectMapper.class).toProvider(ObjectMapperProvider.class);
    }

}
