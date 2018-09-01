package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.IDtoNameResults;
import gbsio.esiclient.api.request.specific.PostRequest;

import java.util.Optional;

/**
 * Performs a bulk lookup of IDs to names.
 * <p></p>
 * The following types of information are checked: Characters, Corporations,
 * Alliances, Stations, Solar Systems, Constellations, Regions, and Inventory
 * Types.
 * <p></p>
 * If one or more of the passed IDs do not resolve to anything, the entire
 * results list will be empty.
 */
final public class IDtoNameRequest implements PostRequest<ImmutableList<IDtoNameResults>> {
    private final ImmutableList<Integer> IDs;

    /**
     * @param IDs 1 to 1,000 IDs to query
     * @throws IllegalArgumentException if IDs contains fewer than 1 or more
     * than 1000 integers
     */
    @SuppressWarnings("WeakerAccess")
    public IDtoNameRequest(final ImmutableList<Integer> IDs) {
        Preconditions.checkNotNull(IDs);
        Preconditions.checkArgument(IDs.size() > 0, "At least one ID must be provided");
        Preconditions.checkArgument(IDs.size() <= 1000, "At most 1000 IDs may be provided");
        this.IDs = IDs;
    }

    @Override
    public String getURL() {
        return "/v2/universe/names/";
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(IDs);
    }

    @Override
    public TypeReference<ImmutableList<IDtoNameResults>> getExpectedType() {
        return new TypeReference<ImmutableList<IDtoNameResults>>() {
        };
    }
}
