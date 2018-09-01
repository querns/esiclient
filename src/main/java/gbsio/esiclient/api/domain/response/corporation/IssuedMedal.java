package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.Medal;
import gbsio.esiclient.internal.domain.response.corporations.IssuedMedalImpl;

import java.time.ZonedDateTime;

/**
 * Represents an instance of a medal being issued to a character in a
 * corporation.
 */
@JsonDeserialize(as = IssuedMedalImpl.class)
public interface IssuedMedal {
    /**
     * Get the character ID of the recipient of the medal.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID of the recipient
     */
    int getRecipientCharacterID();

    /**
     * Get the issue date of the medal.
     *
     * @return the issue date of the medal
     */
    ZonedDateTime getIssueDate();

    /**
     * Get the character ID of the issuer of the medal.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the issuer's character ID
     */
    int getIssuerCharacterID();

    /**
     * Get the ID for this medal.
     *
     * @return the medal ID
     */
    int getMedalID();

    /**
     * Get the user-supplied reason for the issuing of this medal.
     *
     * @return the reason
     */
    String getReason();

    /**
     * Get the privacy status of this instance of the medal.
     *
     * @return the privacy status
     */
    Medal.PrivacyStatus getPrivacyStatus();
}
