package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.common.Medal;
import gbsio.esiclient.internal.domain.response.corporations.CorporationMedalImpl;

import java.time.ZonedDateTime;

@JsonDeserialize(as = CorporationMedalImpl.class)
public interface CorporationMedal extends Medal {
    /**
     * Get the creator of this medal.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID of the creator of the medal
     * @see CharacterInfo
     */
    int getCreatorID();

    /**
     * Get the creation date of this medal.
     *
     * @return the creation date
     */
    ZonedDateTime getCreatedAt();
}
