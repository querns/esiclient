package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.corporation.CorporationIconURLs;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves the URLs for various resolutions of the corporation's icon.
 */
final public class CorporationIconURLsRequest implements GetRequest<CorporationIconURLs> {
    private final int corporationID;

    /**
     * @param corporationID the ID of the corporation to query
     */
    public CorporationIconURLsRequest(final int corporationID) {
        this.corporationID = corporationID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/icons/", corporationID);
    }

    @Override
    public TypeReference<CorporationIconURLs> getExpectedType() {
        return new TypeReference<CorporationIconURLs>() {
        };
    }
}
