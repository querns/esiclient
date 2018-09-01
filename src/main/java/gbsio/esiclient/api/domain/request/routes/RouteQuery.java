package gbsio.esiclient.api.domain.request.routes;

import com.google.common.collect.ImmutableList;
import org.javatuples.Pair;

import java.util.Optional;

/**
 * Represents information needed to ask the Eve server for a gate route between
 * two solar systems.
 */
public interface RouteQuery {
    /**
     * Gets the ID of the origin solar system for this route.
     *
     * @return the origin solar system ID
     */
    int getOriginSolarSystemID();

    /**
     * Gets the ID of the destination solar system for this route.
     *
     * @return the destination solar system ID
     */
    int getDestinationSolarSystemID();

    /**
     * Gets a list of IDs of solar systems that should be avoided on this route
     * whenever possible.
     *
     * @return 0 or more solar system IDs to be avoided
     */
    ImmutableList<Integer> getAvoidedSolarSystemIDs();

    /**
     * Gets a list of pairs of solar system IDs that should be visited along the
     * route.
     *
     * @return 0 or more solar system ID pairs
     */
    ImmutableList<Pair<Integer, Integer>> getConnectedSolarSystemIDPairs();

    /**
     * Gets the preference for the security of solar systems used for this
     * route.
     *
     * @return a security preference, or absent if it's not a concern
     */
    Optional<SecurityPreference> getSecurityPreference();
}
