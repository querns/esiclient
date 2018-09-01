package gbsio.esiclient.api.domain.response.factionwarfare;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.factionwarfare.CorporationStatsImpl;

import java.util.Optional;

/**
 * Represents statistics about a corporation enrolled in faction warfare.
 */
@JsonDeserialize(as = CorporationStatsImpl.class)
public interface CorporationStats extends ConcernStats {
    /**
     * Gets the number of pilots the corporation has.
     *
     * @return the pilot count, or absent if the corporation is not enrolled in
     * faction warfare.
     */
    Optional<Integer> getPilotCount();
}
