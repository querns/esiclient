package gbsio.esiclient.client.request.clones;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Requests a list of typeIDs of the implants of a character's active clone.
 */
final public class ActiveCloneImplantsRequest implements GetRequest<ImmutableList<Integer>> {
    private final int characterID;
    private final String accessToken;

    public ActiveCloneImplantsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/implants/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
