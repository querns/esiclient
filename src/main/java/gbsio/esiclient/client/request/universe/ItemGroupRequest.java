package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.ItemGroup;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about an item group.
 */
final public class ItemGroupRequest implements GetRequest<ItemGroup>, I18Nable {
    private final int groupID;
    private final Language language;

    /**
     * @param groupID the item group ID to query
     * @param language the language to return results as
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public ItemGroupRequest(final int groupID, final Language language) {
        this.groupID = groupID;
        this.language = language;
    }

    /**
     * Creates a request with the default language of en-us.
     * @param groupID the item group ID to query
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public ItemGroupRequest(final int groupID) {
        this(groupID, null);
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/groups/%d/", groupID);
    }

    @Override
    public TypeReference<ItemGroup> getExpectedType() {
        return new TypeReference<ItemGroup>() {
        };
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
