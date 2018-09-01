package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.SystemJumpData;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about jumps performed in solar systems in Eve.
 * <p></p>
 * Only systems where jumps occurred will be listed. Does not include wormhole
 * space.
 */
final public class JumpsRequest implements GetRequest<ImmutableList<SystemJumpData>> {
    @Override
    public String getURL() {
        return "/v1/universe/system_jumps/";
    }

    @Override
    public TypeReference<ImmutableList<SystemJumpData>> getExpectedType() {
        return new TypeReference<ImmutableList<SystemJumpData>>() {
        };
    }
}
