package gbsio.esiclient.client.request.wars;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Map;

/**
 * Retrieves a list of war IDs.
 */
final public class WarIDsRequest implements GetRequest<ImmutableList<Integer>> {
    private final Integer maxWarID;

    /**
     * Creates a request for the 2,000 most recent war IDs.
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public WarIDsRequest() {
        this(null);
    }

    /**
     * Creates a request for war IDs further back in history.
     * @param maxWarID only return war IDs smaller than this ID
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public WarIDsRequest(final Integer maxWarID) {
        this.maxWarID = maxWarID;
    }

    @Override
    public String getURL() {
        return "/v1/wars/";
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        if (null != maxWarID) {
            return ImmutableMap.of("max_war_id", maxWarID);
        }
        return ImmutableMap.of();
    }
}
