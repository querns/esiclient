package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.Bloodline;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves character bloodlines from the server.
 */
final public class BloodlinesRequest implements GetRequest<ImmutableList<Bloodline>>, I18Nable {
    private final Language language;

    /**
     * Creates a request with the default language of en-us.
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public BloodlinesRequest() {
        this(null);
    }

    /**
     * @param language the language to return results as
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public BloodlinesRequest(final Language language) {
        this.language = language;
    }

    @Override
    public String getURL() {
        return "/v1/universe/bloodlines/";
    }

    @Override
    public TypeReference<ImmutableList<Bloodline>> getExpectedType() {
        return new TypeReference<ImmutableList<Bloodline>>() {
        };
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
