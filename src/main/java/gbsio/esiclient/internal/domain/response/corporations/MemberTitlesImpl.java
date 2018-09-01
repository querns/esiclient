package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.MemberTitles;

public class MemberTitlesImpl implements MemberTitles {
    private final int characterID;
    private final ImmutableList<Integer> titleIDs;

    MemberTitlesImpl(
        @JsonProperty(value = "character_id", required = true)
        final int characterID,
        @JsonProperty(value = "titles", required = true)
        final ImmutableList<Integer> titleIDs
    ) {
        this.characterID = characterID;
        this.titleIDs = titleIDs;
    }

    @Override
    public int getCharacterID() {
        return characterID;
    }

    @Override
    public ImmutableList<Integer> getTitleIDs() {
        return titleIDs;
    }
}
