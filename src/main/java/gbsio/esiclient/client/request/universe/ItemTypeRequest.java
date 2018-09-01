package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.ItemType;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about an item type in Eve.
 */
final public class ItemTypeRequest implements GetRequest<ItemType>, I18Nable {
    private final int itemTypeID;
    private final Language language;

    /**
     * @param itemTypeID the ID of the item type to query
     * @param language the language to return results as
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public ItemTypeRequest(final int itemTypeID, final Language language) {
        this.itemTypeID = itemTypeID;
        this.language = language;
    }

    /**
     * Creates a request with the default language of en-us.
     * @param itemTypeID the ID of the item type to query
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public ItemTypeRequest(final int itemTypeID) {
        this(itemTypeID, null);
    }

    @Override
    public String getURL() {
        return String.format("/v3/universe/types/%d/", itemTypeID);
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }

    @Override
    public TypeReference<ItemType> getExpectedType() {
        return new TypeReference<ItemType>() { };
    }
}
