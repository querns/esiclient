package gbsio.esiclient.api.domain.response.wars;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.wars.PartyImpl;

import java.util.Optional;

/**
 * Used to indicate either a corporation or an alliance that is a party in a
 * war.
 */
@JsonDeserialize(as = PartyImpl.class)
public interface Party {
    /**
     * Gets the ID of the party, if it is an alliance.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the alliance ID
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    Optional<Integer> getAllianceID();

    /**
     * Gets the ID of the party, if it is a corporation.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see gbsio.esiclient.api.domain.response.corporation.CorporationInfo
     */
    Optional<Integer> getCorporationID();
}
