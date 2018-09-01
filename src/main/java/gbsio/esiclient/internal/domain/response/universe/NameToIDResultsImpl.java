package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.IDNamePair;
import gbsio.esiclient.api.domain.response.universe.NameToIDResults;

public class NameToIDResultsImpl implements NameToIDResults {
    private final ImmutableList<IDNamePair> agents;
    private final ImmutableList<IDNamePair> alliances;
    private final ImmutableList<IDNamePair> characters;
    private final ImmutableList<IDNamePair> constellations;
    private final ImmutableList<IDNamePair> corporations;
    private final ImmutableList<IDNamePair> factions;
    private final ImmutableList<IDNamePair> itemTypes;
    private final ImmutableList<IDNamePair> regions;
    private final ImmutableList<IDNamePair> stations;
    private final ImmutableList<IDNamePair> solarSystems;

    NameToIDResultsImpl(
        @JsonProperty("agents")
        final ImmutableList<IDNamePair> agents,
        @JsonProperty("alliances")
        final ImmutableList<IDNamePair> alliances,
        @JsonProperty("characters")
        final ImmutableList<IDNamePair> characters,
        @JsonProperty("constellations")
        final ImmutableList<IDNamePair> constellations,
        @JsonProperty("corporations")
        final ImmutableList<IDNamePair> corporations,
        @JsonProperty("factions")
        final ImmutableList<IDNamePair> factions,
        @JsonProperty("inventory_types")
        final ImmutableList<IDNamePair> itemTypes,
        @JsonProperty("regions")
        final ImmutableList<IDNamePair> regions,
        @JsonProperty("stations")
        final ImmutableList<IDNamePair> stations,
        @JsonProperty("systems")
        final ImmutableList<IDNamePair> solarSystems
    ) {
        this.agents = MoreObjects.firstNonNull(agents, ImmutableList.of());
        this.alliances = MoreObjects.firstNonNull(alliances, ImmutableList.of());
        this.characters = MoreObjects.firstNonNull(characters, ImmutableList.of());
        this.constellations = MoreObjects.firstNonNull(constellations, ImmutableList.of());
        this.corporations = MoreObjects.firstNonNull(corporations, ImmutableList.of());
        this.factions = MoreObjects.firstNonNull(factions, ImmutableList.of());
        this.itemTypes = MoreObjects.firstNonNull(itemTypes, ImmutableList.of());
        this.regions = MoreObjects.firstNonNull(regions, ImmutableList.of());
        this.stations = MoreObjects.firstNonNull(stations, ImmutableList.of());
        this.solarSystems = MoreObjects.firstNonNull(solarSystems, ImmutableList.of());
    }

    @Override
    public ImmutableList<IDNamePair> getAgents() {
        return agents;
    }

    @Override
    public ImmutableList<IDNamePair> getAlliances() {
        return alliances;
    }

    @Override
    public ImmutableList<IDNamePair> getCharacters() {
        return characters;
    }

    @Override
    public ImmutableList<IDNamePair> getConstellations() {
        return constellations;
    }

    @Override
    public ImmutableList<IDNamePair> getCorporations() {
        return corporations;
    }

    @Override
    public ImmutableList<IDNamePair> getFactions() {
        return factions;
    }

    @Override
    public ImmutableList<IDNamePair> getItemTypes() {
        return itemTypes;
    }

    @Override
    public ImmutableList<IDNamePair> getRegions() {
        return regions;
    }

    @Override
    public ImmutableList<IDNamePair> getStations() {
        return stations;
    }

    @Override
    public ImmutableList<IDNamePair> getSolarSystems() {
        return solarSystems;
    }
}
