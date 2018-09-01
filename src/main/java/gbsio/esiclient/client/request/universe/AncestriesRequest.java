package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.Ancestry;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves data about character ancestries.
 */
final public class AncestriesRequest implements GetRequest<ImmutableList<Ancestry>>, I18Nable {
    private final Language language;

    @SuppressWarnings({"WeakerAccess", "unused"})
    public AncestriesRequest() {
        this(null);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public AncestriesRequest(final Language language) {
        this.language = language;
    }

    @Override
    public String getURL() {
        return "/v1/universe/ancestries/";
    }

    @Override
    public TypeReference<ImmutableList<Ancestry>> getExpectedType() {
        return new TypeReference<ImmutableList<Ancestry>>() {
        };
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
