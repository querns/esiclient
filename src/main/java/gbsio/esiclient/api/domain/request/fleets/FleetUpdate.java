package gbsio.esiclient.api.domain.request.fleets;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

/**
 * Represents information used to update a fleet.
 */
public interface FleetUpdate {
    /**
     * Gets the new Free Move status of the fleet.
     *
     * @return true if free move should be turned on, false if free move should
     * be turned off, or absent if no change is desired
     */
    @JsonGetter("is_free_move")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<Boolean> isFreeMove();

    /**
     * Gets the new MOTD for the fleet.
     * @return the MOTD, or absent if no change is desired
     */
    @JsonGetter("motd")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<String> getMOTD();
}
