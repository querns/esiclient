package gbsio.esiclient.client.request.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.industry.IndustryJob;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Retrieves the last 2,000 industry jobs for a character.
 */
final public class CharacterIndustryJobsRequest implements GetRequest<ImmutableList<IndustryJob>> {
    private final int characterID;
    private final String accessToken;
    private final boolean includeCompleted;

    /**
     * Creates a request that does not include completed jobs in the response.
     *
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public CharacterIndustryJobsRequest(final int characterID, final String accessToken) {
        this(characterID, accessToken, false);
    }

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param includeCompleted whether or not to include completed jobs in the
     *                         response
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public CharacterIndustryJobsRequest(final int characterID, final String accessToken, final boolean includeCompleted) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.includeCompleted = includeCompleted;
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/industry/jobs/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<IndustryJob>> getExpectedType() {
        return new TypeReference<ImmutableList<IndustryJob>>() {
        };
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of("include_completed", includeCompleted);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
