package gbsio.esiclient.client.request.alliance;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.alliance.AllianceInfo;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Requests detailed information about a single alliance.
 */
final public class AllianceInfoRequest implements GetRequest<AllianceInfo> {
    private final int allianceID;

    /**
     * @param allianceID The ID of the alliance to pull
     */
    public AllianceInfoRequest(int allianceID) {
        this.allianceID = allianceID;
    }

    @Override
    public String getURL() {
        return String.format("/v3/alliances/%d/", allianceID);
    }

    @Override
    public TypeReference<AllianceInfo> getExpectedType() {
        return new TypeReference<AllianceInfo>() {
        };
    }
}
