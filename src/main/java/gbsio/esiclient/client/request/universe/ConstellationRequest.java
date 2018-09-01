package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.Constellation;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about a constellation.
 */
final public class ConstellationRequest implements GetRequest<Constellation>, I18Nable {
    private final int constellationID;
    private final Language language;

    /**
     * @param constellationID the ID of the constellation to query
     * @param language the language the results should return as
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public ConstellationRequest(final int constellationID, final Language language) {
        this.constellationID = constellationID;
        this.language = language;
    }

    /**
     * Creates a request with the default language of en-us.
     * @param constellationID the ID of the constellation to query
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public ConstellationRequest(final int constellationID) {
        this(constellationID, null);
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/constellations/%d/", constellationID);
    }

    @Override
    public TypeReference<Constellation> getExpectedType() {
        return new TypeReference<Constellation>() {
        };
    }
}
