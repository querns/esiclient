package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Colony;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Link;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Pin;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Route;

public class ColonyImpl implements Colony {
    private final ImmutableList<Link> links;
    private final ImmutableList<Pin> pins;
    private final ImmutableList<Route> routes;

    ColonyImpl(
        @JsonProperty(value = "links", required = true)
        final ImmutableList<Link> links,
        @JsonProperty(value = "pins", required = true)
        final ImmutableList<Pin> pins,
        @JsonProperty(value = "routes", required = true)
        final ImmutableList<Route> routes
    ) {
        this.links = MoreObjects.firstNonNull(links, ImmutableList.of());
        this.pins = MoreObjects.firstNonNull(pins, ImmutableList.of());
        this.routes = MoreObjects.firstNonNull(routes, ImmutableList.of());
    }

    @Override
    public ImmutableList<Link> getLinks() {
        return links;
    }

    @Override
    public ImmutableList<Pin> getPins() {
        return pins;
    }

    @Override
    public ImmutableList<Route> getRoutes() {
        return routes;
    }
}
