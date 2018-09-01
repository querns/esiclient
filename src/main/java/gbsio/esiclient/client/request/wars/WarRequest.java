package gbsio.esiclient.client.request.wars;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.wars.War;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about a specific war.
 */
final public class WarRequest implements GetRequest<War> {
    private final int warID;

    /**
     * @param warID the ID of the war to query
     */
    public WarRequest(final int warID) {
        this.warID = warID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/wars/%d/", warID);
    }

    @Override
    public TypeReference<War> getExpectedType() {
        return new TypeReference<War>() {
        };
    }
}
