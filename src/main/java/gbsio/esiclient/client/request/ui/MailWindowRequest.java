package gbsio.esiclient.client.request.ui;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.ui.PrefilledMail;
import gbsio.esiclient.api.request.specific.BooleanPostRequest;
import gbsio.esiclient.client.validation.ui.PrefilledMailValidator;

import java.util.Optional;

/**
 * Opens a window in-game to send a mail, optionally with information prefilled.
 */
final public class MailWindowRequest implements BooleanPostRequest {
    private final String accessToken;
    private final PrefilledMail mail;

    /**
     * @param accessToken an OAuth2 access token belonging to the character that
     *                    the window should be opened for
     * @param mail information to be pre-populated into the mail dialog
     */
    public MailWindowRequest(final String accessToken, final PrefilledMail mail) {
        this.accessToken = Preconditions.checkNotNull(accessToken);
        PrefilledMailValidator.validate(mail);
        this.mail = mail;
    }

    @Override
    public String getURL() {
        //noinspection SpellCheckingInspection
        return "/v1/ui/openwindow/newmail/";
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(mail);
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
