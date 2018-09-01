package gbsio.functional.request.unauthenticated.routes;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.routes.RouteQuery;
import gbsio.esiclient.api.domain.request.routes.SecurityPreference;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.domain.routes.RouteQueryBuilder;
import gbsio.esiclient.client.request.routes.RouteRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RouteRequestTest extends FunctionalTestHarness {
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    void request() {
        // Route is between Jita and Amarr, avoiding 1DQ1-A, and passing through madir/niarja
        final RouteQuery routeQuery = new RouteQueryBuilder(30000142, 30002187)
            .setSecurityPreference(SecurityPreference.SECURE)
            .addAvoidedSolarSystemID(30004759)
            .addConnectedSolarSystemIDPair(30003503, 30003504)
            .addConnectedSolarSystemIDPair(30000142, 30000144)
            .build();
        final Response<ImmutableList<Integer>> response = getClient().sendRequest(new RouteRequest(
            routeQuery
        )).join();
        final ImmutableList<Integer> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}