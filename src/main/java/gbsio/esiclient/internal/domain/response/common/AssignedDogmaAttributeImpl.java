package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaAttribute;

public class AssignedDogmaAttributeImpl implements AssignedDogmaAttribute {
    private final int attributeID;
    private final float number;

    public AssignedDogmaAttributeImpl(
        @JsonProperty(value = "attribute_id", required = true)
        final int attributeID,
        @JsonProperty(value = "value", required = true)
        final float number
    ) {
        this.attributeID = attributeID;
        this.number = number;
    }

    @Override
    public int getAttributeID() {
        return attributeID;
    }

    @Override
    public float getNumber() {
        return number;
    }
}
