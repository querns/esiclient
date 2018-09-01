package gbsio.esiclient.client.request.ui;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.specific.BooleanPostRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Opens the market window for a specified item type ID for a character.
 */
final public class MarketWindowRequest implements BooleanPostRequest {
    private final int itemTypeID;
    private final String accessToken;

    /**
     * @param accessToken an OAuth2 access token belonging to the character that
     *                    the window should open for
     * @param itemTypeID the item type ID to query
     */
    public MarketWindowRequest(final String accessToken, final int itemTypeID) {
        this.itemTypeID = itemTypeID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        //noinspection SpellCheckingInspection
        return "/v1/ui/openwindow/marketdetails/";
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.empty();
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of("type_id", itemTypeID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
