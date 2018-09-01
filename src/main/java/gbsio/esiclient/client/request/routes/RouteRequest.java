package gbsio.esiclient.client.request.routes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.request.routes.RouteQuery;
import gbsio.esiclient.api.request.specific.GetRequest;
import gbsio.esiclient.internal.util.ImmutableListCollector;

import java.util.Map;

/**
 * Retrieves a route between two solar systems.
 *
 * Response contains a list of solar system IDs to visit on the route.
 */
final public class RouteRequest implements GetRequest<ImmutableList<Integer>> {
    private final RouteQuery routeQuery;

    /**
     * @param routeQuery options to use when plotting the route
     */
    public RouteRequest(final RouteQuery routeQuery) {
        this.routeQuery = routeQuery;
    }

    @Override
    public String getURL() {
        return String.format("/v1/route/%d/%d/", routeQuery.getOriginSolarSystemID(), routeQuery.getDestinationSolarSystemID());
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();

        if (routeQuery.getSecurityPreference().isPresent()) {
            builder.put("flag", routeQuery.getSecurityPreference().get().getIdentifier());
        }

        if (routeQuery.getAvoidedSolarSystemIDs().size() > 0) {
            builder.put("avoid", routeQuery.getAvoidedSolarSystemIDs());
        }

        if (routeQuery.getConnectedSolarSystemIDPairs().size() > 0) {
            builder.put("connections",
                routeQuery.getConnectedSolarSystemIDPairs().stream()
                    .map(pair -> String.format("%d|%d", pair.getValue0(), pair.getValue1()))
                    .collect(new ImmutableListCollector<>())
            );
        }

        return builder.build();
    }
}
