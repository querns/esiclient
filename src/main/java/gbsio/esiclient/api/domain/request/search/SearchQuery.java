package gbsio.esiclient.api.domain.request.search;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents information used to search for various types of things in Eve
 * Online.
 * @see gbsio.esiclient.api.domain.response.search.SearchResults
 */
public interface SearchQuery {
    /**
     * Gets a set of categories.
     *
     * Used to constrain the search to only specific types of things.
     *
     * @return 1 or more categories
     */
    Set<SearchCategory> getCategories();

    /**
     * Gets the search string.
     *
     * @return a string
     */
    String getSearchString();

    /**
     * Gets whether or not to only request things that match the search string
     * exactly.
     *
     * @return true if exact match is desired, false if not
     */
    boolean isStrict();

    default String getCategoryQueryString() {
        return getCategories().stream()
            .map(SearchCategory::getIdentifier)
            .collect(Collectors.joining(","));
    }
}
