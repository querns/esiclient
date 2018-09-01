package gbsio.esiclient.client.request.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.Facility;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves a list of NPC industry facilities.
 */
final public class IndustryFacilitiesRequest implements GetRequest<ImmutableList<Facility>> {
    @Override
    public String getURL() {
        return "/v1/industry/facilities/";
    }

    @Override
    public TypeReference<ImmutableList<Facility>> getExpectedType() {
        return new TypeReference<ImmutableList<Facility>>() {
        };
    }
}
