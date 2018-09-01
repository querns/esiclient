package gbsio.esiclient.api.domain.response.search;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.api.domain.response.universe.Structure;
import gbsio.esiclient.internal.domain.response.search.SearchResultsImpl;

/**
 * Represents a full list of entities matching a partial string provided by the
 * user.
 */
@JsonDeserialize(as = SearchResultsImpl.class)
public interface SearchResults {
    /**
     * Gets the agents that match the search parameters.
     *
     * Agents are stored as characters and can be resolved in the same way as a
     * player character.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more agent character IDs
     * @see CharacterInfo
     */
    ImmutableList<Integer> getAgents();

    /**
     * Gets the alliances that match the search parameters.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more alliance IDs
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    ImmutableList<Integer> getAlliances();

    /**
     * Gets the characters that match the search parameters.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more character IDs
     * @see CharacterInfo
     */
    ImmutableList<Integer> getCharacters();

    /**
     * Gets the constellations that match the search parameters.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more constellation IDs
     * @see gbsio.esiclient.api.domain.response.universe.Constellation
     */
    ImmutableList<Integer> getConstellations();

    /**
     * Gets the corporations that match the search parameters.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more corporation IDs
     * @see CorporationInfo
     */
    ImmutableList<Integer> getCorporations();

    /**
     * Gets the factions that match the search parameters.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more faction IDs
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    ImmutableList<Integer> getFactions();

    /**
     * Gets the item types that match the search parameters.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more item type IDs
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    ImmutableList<Integer> getItemTypes();

    /**
     * Gets the regions that match the search parameters.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more region IDs
     * @see gbsio.esiclient.api.domain.response.universe.Region
     */
    ImmutableList<Integer> getRegions();

    /**
     * Gets the solar systems that match the search parameters.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more solar systems
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    ImmutableList<Integer> getSolarSystems();

    /**
     * Gets the NPC stations that match the search parameters.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more stations
     * @see gbsio.esiclient.api.domain.response.universe.Station
     */
    ImmutableList<Integer> getStations();

    /**
     * Gets the structures that match the search parameters.
     *
     * Will contain zero results for unauthenticated searches.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more structure IDs
     * @see Structure
     */
    ImmutableList<Long> getStructures();
}
