package gbsio.esiclient.client.request.skills;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.skills.TrainedSkillInfo;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves a character's trained skills, total skill points, and unallocated
 * skill points (if any.)
 */
final public class CharacterSkillsRequest implements GetRequest<TrainedSkillInfo> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public CharacterSkillsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v4/characters/%d/skills/", characterID);
    }

    @Override
    public TypeReference<TrainedSkillInfo> getExpectedType() {
        return new TypeReference<TrainedSkillInfo>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
