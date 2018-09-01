package gbsio.esiclient.internal.domain.common.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.common.mail.Recipient;

public class RecipientImpl implements Recipient {
    private final int ID;
    private final Type type;

    RecipientImpl(
        @JsonProperty(value = "recipient_id", required = true)
        final int id,
        @JsonProperty(value = "recipient_type", required = true)
        final Type type
    ) {
        ID = id;
        this.type = type;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public Type getType() {
        return type;
    }
}
