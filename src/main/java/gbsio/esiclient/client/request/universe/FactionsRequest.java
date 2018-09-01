package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.Faction;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about factions in Eve.
 */
final public class FactionsRequest implements GetRequest<ImmutableList<Faction>>, I18Nable {
    private final Language language;

    /**
     * Creates a request with the default language of en-us.
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public FactionsRequest() {
        this(null);
    }

    /**
     * @param language the language to return results as
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public FactionsRequest(final Language language) {
        this.language = language;
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }

    @Override
    public String getURL() {
        return "/v2/universe/factions/";
    }

    @Override
    public TypeReference<ImmutableList<Faction>> getExpectedType() {
        return new TypeReference<ImmutableList<Faction>>() { };
    }
}
