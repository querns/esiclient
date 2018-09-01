package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.SolarSystem;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about a solar system.
 */
final public class SolarSystemRequest implements GetRequest<SolarSystem>, I18Nable {
    private final int solarSystemID;
    private final Language language;

    /**
     * Creates a request with the default language of en-us.
     *
     * @param solarSystemID the ID of the solar system to query
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public SolarSystemRequest(final int solarSystemID) {
        this(solarSystemID, null);
    }

    /**
     * @param solarSystemID the ID of the solar system to query
     * @param language the language to return results as
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public SolarSystemRequest(final int solarSystemID, final Language language) {
        this.solarSystemID = solarSystemID;
        this.language = language;
    }

    @Override
    public String getURL() {
        return String.format("/v4/universe/systems/%d/", solarSystemID);
    }

    @Override
    public TypeReference<SolarSystem> getExpectedType() {
        return new TypeReference<SolarSystem>() {
        };
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
