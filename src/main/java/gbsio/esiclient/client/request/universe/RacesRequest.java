package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Race;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves a list of character and NPC races.
 */
final public class RacesRequest implements GetRequest<ImmutableList<Race>> {
    @Override
    public String getURL() {
        return "/v1/universe/races/";
    }

    @Override
    public TypeReference<ImmutableList<Race>> getExpectedType() {
        return new TypeReference<ImmutableList<Race>>() {
        };
    }
}
