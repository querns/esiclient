package gbsio.esiclient.client.request.skills;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.skills.SkillQueueEntry;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves a character's skill queue.
 */
final public class SkillQueueRequest implements GetRequest<ImmutableList<SkillQueueEntry>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public SkillQueueRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        //noinspection SpellCheckingInspection
        return String.format("/v2/characters/%d/skillqueue/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<SkillQueueEntry>> getExpectedType() {
        return new TypeReference<ImmutableList<SkillQueueEntry>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
