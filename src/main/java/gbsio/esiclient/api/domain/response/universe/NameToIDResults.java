package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.universe.NameToIDResultsImpl;

/**
 * Represents results from searching on the bulk names-to-IDs lookup.
 */
@JsonDeserialize(as = NameToIDResultsImpl.class)
public interface NameToIDResults {
    /**
     * Gets the agents that match the search query.
     *
     * @return 0 or more agents
     */
    ImmutableList<IDNamePair> getAgents();

    /**
     * Gets the alliances that match the search query.
     *
     * @return 0 or more agents
     */
    ImmutableList<IDNamePair> getAlliances();

    /**
     * Gets the characters that match the search query.
     *
     * @return 0 or more characters
     */
    ImmutableList<IDNamePair> getCharacters();

    /**
     * Gets the constellations that match the search query.
     *
     * @return 0 or more constellations
     */
    ImmutableList<IDNamePair> getConstellations();

    /**
     * Gets the corporations that match the search query.
     *
     * @return 0 or more corporations
     */
    ImmutableList<IDNamePair> getCorporations();
    /**
     * Gets the factions that match the search query.
     *
     * @return 0 or more factions
     */
    ImmutableList<IDNamePair> getFactions();
    /**
     * Gets the item types that match the search query.
     *
     * @return 0 or more item types
     */
    ImmutableList<IDNamePair> getItemTypes();
    /**
     * Gets the regions that match the search query.
     *
     * @return 0 or more regions
     */
    ImmutableList<IDNamePair> getRegions();
    /**
     * Gets the stations that match the search query.
     *
     * @return 0 or more stations
     */
    ImmutableList<IDNamePair> getStations();
    /**
     * Gets the solar systems that match the search query.
     *
     * @return 0 or more solar systems
     */
    ImmutableList<IDNamePair> getSolarSystems();
}
