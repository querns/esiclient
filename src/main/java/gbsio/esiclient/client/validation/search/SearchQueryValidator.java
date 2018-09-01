package gbsio.esiclient.client.validation.search;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.search.SearchCategory;
import gbsio.esiclient.api.domain.request.search.SearchQuery;

public class SearchQueryValidator {
    public static void validate(SearchQuery query, boolean isAuthenticated) {
        if (!isAuthenticated && query.getCategories().contains(SearchCategory.STRUCTURE)) {
            throw new IllegalArgumentException(
                "Unauthenticated searches cannot search for structures"
            );

        }

        Preconditions.checkArgument(
            query.getCategories().size() > 0,
            "Searches must contain at least one category"
        );

        Preconditions.checkArgument(
            query.getSearchString().length() > 0,
            "The search string must have at least one character"
        );
    }
}
