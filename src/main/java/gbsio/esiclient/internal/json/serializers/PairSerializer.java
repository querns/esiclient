package gbsio.esiclient.internal.json.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.javatuples.Pair;

import java.io.IOException;

public class PairSerializer extends JsonSerializer<Pair> {
    @Override
    public void serialize(final Pair pair, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeObject(pair.getValue0());
        jsonGenerator.writeObject(pair.getValue1());
        jsonGenerator.writeEndArray();
    }
}
