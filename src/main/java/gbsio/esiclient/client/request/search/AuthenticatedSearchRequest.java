package gbsio.esiclient.client.request.search;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.request.search.SearchQuery;
import gbsio.esiclient.api.domain.response.search.SearchResults;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;
import gbsio.esiclient.client.validation.search.SearchQueryValidator;

import java.util.Map;
import java.util.Optional;

/**
 * Performs a search for various objects in Eve.
 *
 * Differs from a {@link SearchRequest} in that it can accept a {@link gbsio.esiclient.api.domain.request.search.SearchCategory#STRUCTURE}
 * if the authenticated character is on the structure's ACL.
 */
final public class AuthenticatedSearchRequest implements GetRequest<SearchResults>, I18Nable {
    private final int characterID;
    private final String accessToken;
    private final SearchQuery searchQuery;
    private final Language language;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param searchQuery options for the desired search
     * @param language the language to return results as
     */
    @SuppressWarnings({"WeakerAccess","unused"})
    public AuthenticatedSearchRequest(final int characterID, final String accessToken, final SearchQuery searchQuery, Language language) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        SearchQueryValidator.validate(searchQuery, true);
        this.searchQuery = searchQuery;
        this.language = language;
    }

    /**
     * Creates a request with the default language of en-us.
     *
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param searchQuery options for the desired search
     */
    @SuppressWarnings({"WeakerAccess","unused"})
    public AuthenticatedSearchRequest(final int characterID, final String accessToken, final SearchQuery searchQuery) {
        this(characterID, accessToken, searchQuery, null);
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of(
            "categories", searchQuery.getCategoryQueryString(),
            "search", searchQuery.getSearchString(),
            "strict", searchQuery.isStrict()
        );
    }

    @Override
    public TypeReference<SearchResults> getExpectedType() {
        return new TypeReference<SearchResults>() {
        };
    }

    @Override
    public String getURL() {
        return String.format("/v3/characters/%d/search/", characterID);
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
