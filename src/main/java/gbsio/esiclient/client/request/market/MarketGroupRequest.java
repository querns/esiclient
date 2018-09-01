package gbsio.esiclient.client.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.market.MarketGroup;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about a single market group.
 */
final public class MarketGroupRequest implements GetRequest<MarketGroup>, I18Nable {
    private final int marketGroupID;
    private final Language language;

    /**
     * @param marketGroupID the ID of the market group to query
     * @param language the language desired for info returned
     */
    @SuppressWarnings("WeakerAccess")
    public MarketGroupRequest(final int marketGroupID, final Language language) {
        this.marketGroupID = marketGroupID;
        this.language = language;
    }

    /**
     * Creates a request with the default language of en-us.
     *
     * @param marketGroupID the ID of the market group to query
     */
    @SuppressWarnings("unused")
    public MarketGroupRequest(final int marketGroupID) {
        this(marketGroupID, null);
    }

    @Override
    public String getURL() {
        return String.format("/v1/markets/groups/%d/", marketGroupID);
    }

    @Override
    public TypeReference<MarketGroup> getExpectedType() {
        return new TypeReference<MarketGroup>() {
        };
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
