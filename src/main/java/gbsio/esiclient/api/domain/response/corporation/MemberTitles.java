package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.internal.domain.response.corporations.MemberTitlesImpl;

/**
 * Represents an entry in a list containing a character and the titles their
 * corporation has bestowed.
 */
@JsonDeserialize(as = MemberTitlesImpl.class)
public interface MemberTitles {
    /**
     * Get the ID for the character this entry represents.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return a character ID
     * @see CharacterInfo
     */
    int getCharacterID();

    /**
     * Gets a list of the IDs of titles assigned to this character.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return a list of title IDs
     * @see CorporationTitle
     */
    ImmutableList<Integer> getTitleIDs();
}
