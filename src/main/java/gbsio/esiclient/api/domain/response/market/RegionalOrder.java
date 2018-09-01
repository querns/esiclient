package gbsio.esiclient.api.domain.response.market;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.market.RegionalOrderImpl;

/**
 * Represents an order belonging to someone else, pulled at regional scope.
 */
@JsonDeserialize(as = RegionalOrderImpl.class)
public interface RegionalOrder extends Order {
    /**
     * Gets the ID of the solar system where this order is located.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();
}
