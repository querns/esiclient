package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.ItemCategory;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about a single item category.
 */
final public class ItemCategoryRequest implements GetRequest<ItemCategory>, I18Nable {
    private final int categoryID;
    private final Language language;

    /**
     * @param categoryID the ID of the item category to query
     * @param language the language to return results as
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public ItemCategoryRequest(final int categoryID, final Language language) {
        this.categoryID = categoryID;
        this.language = language;
    }

    /**
     * Creates a request with the default language of en-us.
     * @param categoryID the ID of the item category to query
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public ItemCategoryRequest(final int categoryID) {
        this(categoryID, null);
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/categories/%d/", categoryID);
    }

    @Override
    public TypeReference<ItemCategory> getExpectedType() {
        return new TypeReference<ItemCategory>() {
        };
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
