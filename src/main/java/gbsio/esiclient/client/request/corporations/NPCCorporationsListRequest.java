package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Gets a list of IDs of NPC corporations.
 */
final public class NPCCorporationsListRequest implements GetRequest<ImmutableList<Integer>> {
    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public String getURL() {
        return "/v1/corporations/npccorps/";
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }
}
