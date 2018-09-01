package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.NameToIDResults;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.PostRequest;

import java.util.Optional;

/**
 * Performs a bulk name to ID lookup.
 * <p></p>
 * Results from the following categories of things will be returned: agents,
 * alliances, characters, constellations, corporations factions,
 * inventory types, regions, stations, and systems.
 * <p></p>
 * Only exact matches will be returned. Names that don't match any of those
 * types will be omitted.
 */
final public class NameToIDRequest implements PostRequest<NameToIDResults>, I18Nable {
    private final ImmutableSet<String> names;
    private final Language language;

    /**
     * @param names 1 to 1000 names to look up
     * @param language the preferred language to return
     * @throws IllegalArgumentException if names is less than 1 or more than
     * 1,000 names
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public NameToIDRequest(final ImmutableSet<String> names, final Language language) {
        final int size = names.size();
        Preconditions.checkArgument(size > 0, "There must be at least one name to search for");
        Preconditions.checkArgument(size <= 1000, "There can be at most 1000 names to search for");

        this.names = names;
        this.language = language;
    }

    /**
     * Creates a request with the default language of en-us.
     * @param names 1 to 1000 names to look up
     * @throws IllegalArgumentException if names is less than 1 or more than
     * 1,000 names
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public NameToIDRequest(final ImmutableSet<String> names) {
        this(names, null);
    }

    @Override
    public String getURL() {
        return "/v1/universe/ids/";
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(names);
    }

    @Override
    public TypeReference<NameToIDResults> getExpectedType() {
        return new TypeReference<NameToIDResults>() {
        };
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
