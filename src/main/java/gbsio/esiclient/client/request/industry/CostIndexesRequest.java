package gbsio.esiclient.client.request.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.CostIndexData;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves industry cost indexes for solar systems in Eve Online: A
 * Space-themed Spreadsheet.
 */
final public class CostIndexesRequest implements GetRequest<ImmutableList<CostIndexData>> {
    @Override
    public String getURL() {
        return "/v1/industry/systems/";
    }

    @Override
    public TypeReference<ImmutableList<CostIndexData>> getExpectedType() {
        return new TypeReference<ImmutableList<CostIndexData>>() {
        };
    }
}
