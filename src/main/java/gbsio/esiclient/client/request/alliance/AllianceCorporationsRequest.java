package gbsio.esiclient.client.request.alliance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Gets the IDs of corporations belonging to an alliance.
 */
final public class AllianceCorporationsRequest implements GetRequest<ImmutableList<Integer>> {
    private final int allianceID;

    /**
     * @param allianceID The ID of the alliance to pull
     */
    public AllianceCorporationsRequest(int allianceID) {
        this.allianceID = allianceID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/alliances/%d/corporations/", allianceID);
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }
}
