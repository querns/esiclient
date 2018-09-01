package gbsio.esiclient.internal.domain.response.contacts;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.contacts.ContactLabel;

public class ContactLabelImpl implements ContactLabel {
    private final long ID;
    private final String name;

    ContactLabelImpl(
        @JsonProperty(value = "label_id", required = true)
        final long id,
        @JsonProperty(value = "label_name", required = true)
        final String name
    ) {
        ID = id;
        this.name = name;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }
}
