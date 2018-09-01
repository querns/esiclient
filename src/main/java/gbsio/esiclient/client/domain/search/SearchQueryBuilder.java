package gbsio.esiclient.client.domain.search;

import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.request.search.SearchCategory;
import gbsio.esiclient.api.domain.request.search.SearchQuery;

import java.util.Set;

final public class SearchQueryBuilder {
    private final ImmutableSet.Builder<SearchCategory> builder = ImmutableSet.builder();

    private String searchString;
    private boolean isStrict = false;

    @SuppressWarnings("unused")
    public SearchQueryBuilder(final String searchString, SearchCategory category) {
        this.searchString = searchString;
        builder.add(category);
    }

    @SuppressWarnings("unused")
    public SearchQueryBuilder(final String searchString, SearchCategory ...categories) {
        this.searchString = searchString;
        builder.add(categories);
    }

    @SuppressWarnings("unused")
    public SearchQueryBuilder(final String searchString, final boolean isStrict) {
        this.searchString = searchString;
        this.isStrict = isStrict;
    }

    @SuppressWarnings("unused")
    public SearchQueryBuilder(final String searchString, final boolean isStrict, SearchCategory ...categories) {
        this.searchString = searchString;
        this.isStrict = isStrict;
        builder.add(categories);
    }

    @SuppressWarnings("unused")
    public SearchQueryBuilder setSearchString(final String searchString) {
        this.searchString = searchString;
        return this;
    }

    @SuppressWarnings("unused")
    public SearchQueryBuilder setStrict(final boolean strict) {
        isStrict = strict;
        return this;
    }

    @SuppressWarnings("unused")
    public SearchQueryBuilder addCategory(SearchCategory category) {
        builder.add(category);
        return this;
    }

    @SuppressWarnings("unused")
    public SearchQueryBuilder addCategory(SearchCategory ...categories) {
        builder.add(categories);
        return this;
    }

    public SearchQuery build() {
        return new SearchQueryImpl(
            builder.build(),
            searchString,
            isStrict
        );
    }

    static class SearchQueryImpl implements SearchQuery {
        private final Set<SearchCategory> categories;
        private final String searchString;
        private final boolean isStrict;

        SearchQueryImpl(final Set<SearchCategory> categories, final String searchString, final boolean isStrict) {
            this.categories = categories;
            this.searchString = searchString;
            this.isStrict = isStrict;
        }

        @Override
        public Set<SearchCategory> getCategories() {
            return categories;
        }

        @Override
        public String getSearchString() {
            return searchString;
        }

        @Override
        public boolean isStrict() {
            return isStrict;
        }
    }
}
