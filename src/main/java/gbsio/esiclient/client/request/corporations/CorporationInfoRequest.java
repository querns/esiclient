package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves public information about a corporation.
 */
final public class CorporationInfoRequest implements GetRequest<CorporationInfo> {
    private final int corporationID;

    /**
     * @param corporationID the ID of the corporation to query
     */
    public CorporationInfoRequest(final int corporationID) {
        this.corporationID = corporationID;
    }

    @Override
    public String getURL() {
        return String.format("/v4/corporations/%d/", corporationID);
    }

    @Override
    public TypeReference<CorporationInfo> getExpectedType() {
        return new TypeReference<CorporationInfo>() {
        };
    }
}
