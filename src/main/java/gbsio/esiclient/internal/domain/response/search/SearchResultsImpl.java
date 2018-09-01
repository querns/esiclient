package gbsio.esiclient.internal.domain.response.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.search.SearchResults;

public class SearchResultsImpl implements SearchResults {
    private final ImmutableList<Integer> agents;
    private final ImmutableList<Integer> alliances;
    private final ImmutableList<Integer> characters;
    private final ImmutableList<Integer> constellations;
    private final ImmutableList<Integer> corporations;
    private final ImmutableList<Integer> factions;
    private final ImmutableList<Integer> itemTypes;
    private final ImmutableList<Integer> regions;
    private final ImmutableList<Integer> solarSystems;
    private final ImmutableList<Integer> stations;
    private final ImmutableList<Long> structures;

    SearchResultsImpl(
        @JsonProperty("agent")
        final ImmutableList<Integer> agents,
        @JsonProperty("alliance")
        final ImmutableList<Integer> alliances,
        @JsonProperty("character")
        final ImmutableList<Integer> characters,
        @JsonProperty("constellation")
        final ImmutableList<Integer> constellations,
        @JsonProperty("corporation")
        final ImmutableList<Integer> corporations,
        @JsonProperty("faction")
        final ImmutableList<Integer> factions,
        @JsonProperty("inventory_type")
        final ImmutableList<Integer> itemTypes,
        @JsonProperty("region")
        final ImmutableList<Integer> regions,
        @JsonProperty("solar_system")
        final ImmutableList<Integer> solarSystems,
        @JsonProperty("station")
        final ImmutableList<Integer> stations,
        @JsonProperty("structure")
        final ImmutableList<Long> structures
    ) {
        this.agents = MoreObjects.firstNonNull(agents, ImmutableList.of());
        this.alliances = MoreObjects.firstNonNull(alliances, ImmutableList.of());
        this.characters = MoreObjects.firstNonNull(characters, ImmutableList.of());
        this.constellations = MoreObjects.firstNonNull(constellations, ImmutableList.of());
        this.corporations = MoreObjects.firstNonNull(corporations, ImmutableList.of());
        this.factions = MoreObjects.firstNonNull(factions, ImmutableList.of());
        this.itemTypes = MoreObjects.firstNonNull(itemTypes, ImmutableList.of());
        this.regions = MoreObjects.firstNonNull(regions, ImmutableList.of());
        this.solarSystems = MoreObjects.firstNonNull(solarSystems, ImmutableList.of());
        this.stations = MoreObjects.firstNonNull(stations, ImmutableList.of());
        this.structures = MoreObjects.firstNonNull(structures, ImmutableList.of());
    }

    @Override
    public ImmutableList<Integer> getAgents() {
        return agents;
    }

    @Override
    public ImmutableList<Integer> getAlliances() {
        return alliances;
    }

    @Override
    public ImmutableList<Integer> getCharacters() {
        return characters;
    }

    @Override
    public ImmutableList<Integer> getConstellations() {
        return constellations;
    }

    @Override
    public ImmutableList<Integer> getCorporations() {
        return corporations;
    }

    @Override
    public ImmutableList<Integer> getFactions() {
        return factions;
    }

    @Override
    public ImmutableList<Integer> getItemTypes() {
        return itemTypes;
    }

    @Override
    public ImmutableList<Integer> getRegions() {
        return regions;
    }

    @Override
    public ImmutableList<Integer> getSolarSystems() {
        return solarSystems;
    }

    @Override
    public ImmutableList<Integer> getStations() {
        return stations;
    }

    @Override
    public ImmutableList<Long> getStructures() {
        return structures;
    }
}
