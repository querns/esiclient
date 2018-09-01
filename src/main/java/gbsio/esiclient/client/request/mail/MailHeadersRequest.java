package gbsio.esiclient.client.request.mail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.request.mail.MailHeaderOptions;
import gbsio.esiclient.api.domain.response.mail.MailHeader;
import gbsio.esiclient.api.request.specific.GetRequest;
import gbsio.esiclient.client.domain.mail.MailHeaderOptionsBuilder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Retrieves header information about mails in a character's mailbox.
 */
final public class MailHeadersRequest implements GetRequest<ImmutableList<MailHeader>> {
    private final int characterID;
    private final String accessToken;
    private final MailHeaderOptions options;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     * @param options options to restrict which mails are returned or to query
     *                older mails
     * @see MailHeaderOptionsBuilder
     */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public MailHeadersRequest(final int characterID, final String accessToken, final MailHeaderOptions options) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.options = options;
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public MailHeadersRequest(final int characterID, final String accessToken) {
        this(characterID, accessToken, MailHeaderOptionsBuilder.empty());
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();

        options.getLastMailID().ifPresent(lastMailID -> builder.put("last_mail_id", lastMailID));

        if (options.getFilterToLabelIDs().size() > 0) {
            builder.put("labels", options.getFilterToLabelIDs());
        }

        return builder.build();
    }

    @Override
    public TypeReference<ImmutableList<MailHeader>> getExpectedType() {
        return new TypeReference<ImmutableList<MailHeader>>() {
        };
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/mail/", characterID);
    }

    private static int[] toPrimitiveArray(final List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
