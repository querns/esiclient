package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.universe.Region;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about a region.
 */
final public class RegionRequest implements GetRequest<Region>, I18Nable {
    private final int regionID;
    private final Language language;

    /**
     * @param regionID the ID of the region to query
     * @param language the language to return results as
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public RegionRequest(final int regionID, final Language language) {
        this.regionID = regionID;
        this.language = language;
    }

    /**
     * Creates a request with the default language of en-us.
     * @param regionID the ID of the region to query
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public RegionRequest(final int regionID) {
        this(regionID, null);
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/regions/%d/", regionID);
    }

    @Override
    public TypeReference<Region> getExpectedType() {
        return new TypeReference<Region>() {
        };
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
