package gbsio.esiclient.client.domain.search;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.request.search.SearchCategory;
import gbsio.esiclient.api.domain.request.search.SearchQuery;
import gbsio.esiclient.client.validation.search.SearchQueryValidator;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SearchQueryValidatorTest {
    private static final String VALID_SEARCH_STRING = "valid search string";
    private static final Set<SearchCategory> VALID_UNAUTHENTICATED_SET = ImmutableSet.of(SearchCategory.CHARACTER);
    private static final Set<SearchCategory> VALID_AUTHENTICATED_SET = ImmutableSet.of(SearchCategory.STRUCTURE);

    @Test
    void validate() {
        List<Pair<SearchQuery, Boolean>> list = ImmutableList.of(
            new Pair<>(new SearchQueryBuilder.SearchQueryImpl(ImmutableSet.of(), VALID_SEARCH_STRING, true), false),
            new Pair<>(new SearchQueryBuilder.SearchQueryImpl(VALID_AUTHENTICATED_SET, VALID_SEARCH_STRING, true), false),
            new Pair<>(new SearchQueryBuilder.SearchQueryImpl(VALID_UNAUTHENTICATED_SET, "", true), true)
        );

        list.forEach(pair -> assertThrows(
            IllegalArgumentException.class,
            () -> SearchQueryValidator.validate(pair.getValue0(), pair.getValue1())
        ));
    }
}