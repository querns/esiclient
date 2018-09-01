package gbsio.esiclient.client.request.ui;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.specific.BooleanPostRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Opens an information window in-game for a character, corporation, or
 * alliance.
 */
final public class InformationWindowRequest implements BooleanPostRequest {
    private final int targetID;
    private final String accessToken;

    /**
     * @param accessToken an OAuth2 access token belonging to the character that
     *                    the window should open for
     * @param targetID the ID of a character, corporation, or alliance
     */
    public InformationWindowRequest(final String accessToken, final int targetID) {
        this.targetID = targetID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        //noinspection SpellCheckingInspection
        return "/v1/ui/openwindow/information/";
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.empty();
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        return ImmutableMap.of("target_id", targetID);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
