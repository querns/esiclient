package gbsio.esiclient.client.request.search;

import com.fasterxml.jackson.core.type.TypeReference;
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
 * Differs from an {@link AuthenticatedSearchRequest} in that it cannot find
 * player-owned structures.
 */
final public class SearchRequest implements GetRequest<SearchResults>, I18Nable {
    private final SearchQuery searchQuery;
    private final Language language;

    /**
     * @param searchQuery options for the desired search
     * @param language the language to return results as
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public SearchRequest(final SearchQuery searchQuery, Language language) {
        SearchQueryValidator.validate(searchQuery, false);
        this.searchQuery = searchQuery;
        this.language = language;
    }

    /**
     * Creates a request that returns results in the default language of en-us.
     * @param searchQuery options for the desired search
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public SearchRequest(final SearchQuery searchQuery) {
        this(searchQuery, null);
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
        return "/v2/search/";
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
