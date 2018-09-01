package gbsio.esiclient.internal.domain.response.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.mail.MailingList;

public class MailingListImpl implements MailingList {
    private final int ID;
    private final String name;

    MailingListImpl(
        @JsonProperty(value = "mailing_list_id", required = true)
        final int id,
        @JsonProperty(value = "name", required = true)
        final String name
    ) {
        ID = id;
        this.name = name;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }
}
