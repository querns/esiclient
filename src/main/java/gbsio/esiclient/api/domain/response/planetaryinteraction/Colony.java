package gbsio.esiclient.api.domain.response.planetaryinteraction;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.ColonyImpl;

/**
 * Represents detailed information about the layout of a Planetary Interaction
 * colony.
 */
@JsonDeserialize(as = ColonyImpl.class)
public interface Colony {
    /**
     * Gets the links between pins in a colony.
     *
     * @return 0 or more links
     */
    ImmutableList<Link> getLinks();

    /**
     * Gets the pins (individual buildings) belonging to a colony.
     *
     * @return 0 or more pins
     */
    ImmutableList<Pin> getPins();

    /**
     * Gets the routes of products over links between pins in a colony.
     *
     * @return 0 or more routes
     */
    ImmutableList<Route> getRoutes();
}
