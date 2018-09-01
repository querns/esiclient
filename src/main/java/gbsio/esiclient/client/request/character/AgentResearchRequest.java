package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.AgentResearch;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Pulls agent research (and research points) from ESI.
 */
final public class AgentResearchRequest implements GetRequest<ImmutableList<AgentResearch>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query agent research
     * @param accessToken an OAuth2 access token for said character
     */
    public AgentResearchRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/agents_research/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<AgentResearch>> getExpectedType() {
        return new TypeReference<ImmutableList<AgentResearch>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
