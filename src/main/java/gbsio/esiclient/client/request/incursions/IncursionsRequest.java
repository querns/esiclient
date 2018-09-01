package gbsio.esiclient.client.request.incursions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.incursions.Incursion;
import gbsio.esiclient.api.request.specific.GetRequest;

final public class IncursionsRequest implements GetRequest<ImmutableList<Incursion>> {
    @Override
    public String getURL() {
        return "/v1/incursions/";
    }

    @Override
    public TypeReference<ImmutableList<Incursion>> getExpectedType() {
        return new TypeReference<ImmutableList<Incursion>>() { };
    }
}
