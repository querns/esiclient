package gbsio.esiclient.internal.json.deserializers;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Unpacks a response containing exactly one field into a number without an
 * interstitial object.
 */
public class LongUnpackingDeserializer extends JsonDeserializer<Long> {
    @Override
    public Long deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        final ObjectCodec codec = jsonParser.getCodec();
        final TreeNode node = codec.readTree(jsonParser);

        if (node.isObject() && node.size() == 1) {
            final TreeNode valueNode = node.get(node.fieldNames().next());

            if (valueNode.numberType() == JsonParser.NumberType.LONG) {
                return codec.treeToValue(valueNode, Long.class);
            }
        } else if (
            node.numberType() == JsonParser.NumberType.LONG
            || node.numberType() == JsonParser.NumberType.INT
        ) {
            return Long.valueOf(node.toString());
        }

        throw new ProcessingException("Cannot convert value to Long", jsonParser.getCurrentLocation());
    }
}
