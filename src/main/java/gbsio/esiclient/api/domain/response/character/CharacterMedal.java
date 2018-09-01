package gbsio.esiclient.api.domain.response.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Medal;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.domain.response.character.CharacterMedalImpl;

import java.time.ZonedDateTime;

/**
 * Represents a medal awarded by a corporation to a character.
 */
@JsonDeserialize(as = CharacterMedalImpl.class)
public interface CharacterMedal extends Medal {
    /**
     * Get the corporation ID to which this medal belongs.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    int getCorporationID();

    /**
     * Get the date this medal was issued.
     *
     * @return the issue date
     */
    ZonedDateTime getIssueDate();

    /**
     * Get the graphic layers for this medal.
     *
     * @return the graphic layers
     */
    ImmutableList<MedalGraphicLayer> getGraphics();

    /**
     * Get the ID of the character that issued this medal.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the issuer's character ID
     * @see CharacterInfo
     */
    int getIssuerID();

    /**
     * Get the reason this medal was issued.
     *
     * @return the issue reason
     */
    String getReason();

    /**
     * Get the privacy status for this medal.
     *
     * @return the medal's privacy status
     */
    PrivacyStatus getStatus();

}
