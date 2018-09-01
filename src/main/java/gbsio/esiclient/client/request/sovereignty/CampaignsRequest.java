package gbsio.esiclient.client.request.sovereignty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Campaign;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves active sovereignty capture campaigns.
 */
final public class CampaignsRequest implements GetRequest<ImmutableList<Campaign>> {
    @Override
    public String getURL() {
        return "/v1/sovereignty/campaigns/";
    }

    @Override
    public TypeReference<ImmutableList<Campaign>> getExpectedType() {
        return new TypeReference<ImmutableList<Campaign>>() {
        };
    }
}
