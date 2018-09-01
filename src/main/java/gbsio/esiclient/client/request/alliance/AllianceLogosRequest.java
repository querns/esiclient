package gbsio.esiclient.client.request.alliance;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.alliance.AllianceLogoURLs;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Gets URLs to logos belonging to an alliance.
 */
final public class AllianceLogosRequest implements GetRequest<AllianceLogoURLs> {
    private final int allianceID;

    /**
     * @param allianceID the ID of the alliance to pull
     */
    public AllianceLogosRequest(int allianceID) {
        this.allianceID = allianceID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/alliances/%d/icons/", allianceID);
    }

    @Override
    public TypeReference<AllianceLogoURLs> getExpectedType() {
        return new TypeReference<AllianceLogoURLs>() {
        };
    }
}
