package gbsio.esiclient.client.request.insurance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.insurance.InsurancePriceData;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Pulls data about insurance offers for spaceships.
 */
final public class InsuranceRequest implements GetRequest<ImmutableList<InsurancePriceData>> {
    @Override
    public String getURL() {
        return "/v1/insurance/prices/";
    }

    @Override
    public TypeReference<ImmutableList<InsurancePriceData>> getExpectedType() {
        return new TypeReference<ImmutableList<InsurancePriceData>>() {
        };
    }
}
