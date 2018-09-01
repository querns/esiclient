package gbsio.esiclient.client.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.AdjustedPriceData;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves adjusted item prices from ESI.
 *
 * Adjusted prices are used to calculate industry job costs.
 */
final public class AdjustedPricesRequest implements GetRequest<ImmutableList<AdjustedPriceData>> {
    @Override
    public String getURL() {
        return "/v1/markets/prices/";
    }

    @Override
    public TypeReference<ImmutableList<AdjustedPriceData>> getExpectedType() {
        return new TypeReference<ImmutableList<AdjustedPriceData>>() {
        };
    }
}
