package gbsio.esiclient.client.request.ui;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.specific.BooleanPostRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Opens a contract window for a logged-in character.
 *
 * There is no special feedback if the passed contract ID is invalid.
 */
final public class ContractWindowRequest implements BooleanPostRequest {
    private final int contractID;
    private final String accessToken;

    /**
     * @param accessToken an OAuth2 access token belonging to the character that
     *                    the game should open the window for
     * @param contractID the ID of the contract to open
     */
    public ContractWindowRequest(final String accessToken, final int contractID) {
        this.contractID = contractID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        //noinspection SpellCheckingInspection
        return "/v1/ui/openwindow/contract/";
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of("contract_id", contractID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.empty();
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
