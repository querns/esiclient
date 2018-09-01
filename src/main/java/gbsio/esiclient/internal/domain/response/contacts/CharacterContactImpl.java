package gbsio.esiclient.internal.domain.response.contacts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.CharacterContact;

import java.util.Optional;

public class CharacterContactImpl implements CharacterContact {
    private final Boolean isBlocked;
    private final Boolean isWatched;
    private final int contactID;
    private final ContactType contactType;
    private final ImmutableList<Long> labelIDs;
    private final float standing;

    CharacterContactImpl(
        @JsonProperty("is_blocked")
        final Boolean isBlocked,
        @JsonProperty("is_watched")
        final Boolean isWatched,
        @JsonProperty(value = "contact_id", required = true)
        final int contactID,
        @JsonProperty(value = "contact_type", required = true)
        final ContactType contactType,
        @JsonProperty("label_ids")
        final ImmutableList<Long> labelIDs,
        @JsonProperty(value = "standing", required = true)
        final float standing
    ) {
        this.isBlocked = isBlocked;
        this.isWatched = isWatched;
        this.contactID = contactID;
        this.contactType = contactType;
        this.labelIDs = null == labelIDs ? ImmutableList.of() : labelIDs;
        this.standing = standing;
    }

    @Override
    public Optional<Boolean> isBlocked() {
        return Optional.ofNullable(isBlocked);
    }

    @Override
    public Optional<Boolean> isWatched() {
        return Optional.ofNullable(isWatched);
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
