package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.Affiliation;
import gbsio.esiclient.api.request.specific.PostRequest;

import java.util.Optional;

/**
 * Performs a bulk lookup of the corporation, alliance, and faction of a list of
 * character IDs.
 */
final public class AffiliationRequest implements PostRequest<ImmutableList<Affiliation>> {
    private final ImmutableList<Integer> characterIDs;

    /**
     * @param characterIDs 1 to 1,000 character IDs to query
     */
    public AffiliationRequest(final ImmutableList<Integer> characterIDs) {
        Preconditions.checkNotNull(characterIDs);
        Preconditions.checkArgument(characterIDs.size() > 0, "You must include at least one characterID");
        Preconditions.checkArgument(characterIDs.size() <= 1000, "You may include at most 1,000 characterIDs");
        this.characterIDs = characterIDs;
    }

    @Override
    public String getURL() {
        return "/v1/characters/affiliation/";
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(characterIDs);
    }

    @Override
    public TypeReference<ImmutableList<Affiliation>> getExpectedType() {
        return new TypeReference<ImmutableList<Affiliation>>() {
        };
    }
}
