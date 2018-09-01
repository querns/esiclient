package gbsio.esiclient.client.request.dogma;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.dogma.DogmaEffect;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves details for a single dogma effect.
 */
final public class DogmaEffectDetailRequest implements GetRequest<DogmaEffect> {
    private final int effectID;

    /**
     * @param effectID the ID of the effect to query
     */
    public DogmaEffectDetailRequest(final int effectID) {
        this.effectID = effectID;
    }

    @Override
    public String getURL() {
        return String.format("/v2/dogma/effects/%d/", effectID);
    }

    @Override
    public TypeReference<DogmaEffect> getExpectedType() {
        return new TypeReference<DogmaEffect>() {
        };
    }
}
