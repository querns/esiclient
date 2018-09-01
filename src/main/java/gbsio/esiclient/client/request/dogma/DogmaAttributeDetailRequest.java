package gbsio.esiclient.client.request.dogma;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.dogma.DogmaAttribute;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves details about a dogma attribute.
 */
final public class DogmaAttributeDetailRequest implements GetRequest<DogmaAttribute> {
    private final int attributeID;

    /**
     * @param attributeID the ID of the attribute to query
     */
    public DogmaAttributeDetailRequest(final int attributeID) {
        this.attributeID = attributeID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/dogma/attributes/%d/", attributeID);
    }

    @Override
    public TypeReference<DogmaAttribute> getExpectedType() {
        return new TypeReference<DogmaAttribute>() {
        };
    }
}
