package gbsio.esiclient.internal.domain.response.contacts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.BaseContact;

public class ContactImpl implements BaseContact {
    private final int contactID;
    private final ContactType contactType;
    private final ImmutableList<Long> labelIDs;
    private final float standing;

    ContactImpl(
        @JsonProperty(value = "contact_id", required = true)
        final int contactID,
        @JsonProperty(value = "contact_type", required = true)
        final ContactType contactType,
        @JsonProperty("label_id")
        final ImmutableList<Long> labelIDs,
        @JsonProperty(value = "standing", required = true)
        final float standing
    ) {
        this.contactID = contactID;
        this.contactType = contactType;
        this.labelIDs = null == labelIDs ? ImmutableList.of() : labelIDs;
        this.standing = standing;
    }

    @Override
    public int getContactID() {
        return contactID;
    }

    @Override
    public ContactType getContactType() {
        return contactType;
    }

    @Override
    public ImmutableList<Long> getLabelIDs() {
        return labelIDs;
    }

    @Override
    public float getStanding() {
        return standing;
    }
}
