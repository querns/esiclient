package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.AllianceHistory;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves the alliance history for a corporation.
 */
final public class CorporationAllianceHistoryRequest implements GetRequest<ImmutableList<AllianceHistory>> {
    private final int corporationID;

    /**
     * @param corporationID the ID of a corporation to query
     */
    public CorporationAllianceHistoryRequest(final int corporationID) {
        this.corporationID = corporationID;
    }

    @Override
    public String getURL() {
        //noinspection SpellCheckingInspection
        return String.format("/v2/corporations/%d/alliancehistory/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<AllianceHistory>> getExpectedType() {
        return new TypeReference<ImmutableList<AllianceHistory>>() {
        };
    }
}
