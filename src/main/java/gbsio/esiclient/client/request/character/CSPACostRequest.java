package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.PostRequest;
import gbsio.esiclient.client.request.mail.SendMailRequest;

import java.util.Optional;

/**
 * Calculates the CSPA charge required to send a mail.
 *
 * Response contains an amount in ISK required to send a mail with the same
 * recipients.
 *
 * It is recommended to use this endpoint to provide a required argument for a
 * {@link SendMailRequest}.
 */
final public class CSPACostRequest implements PostRequest<Float> {
    private final int sourceCharacterID;
    private final String accessToken;
    private final ImmutableList<Integer> targetCharacterIDs;

    /**
     * @param sourceCharacterID the ID of the character requesting the CSPA charges
     * @param accessToken an OAuth access token belonging to said character
     * @param targetCharacterIDs 1 to 100 IDs of characters to query
     */
    public CSPACostRequest(final int sourceCharacterID, final String accessToken, final ImmutableList<Integer> targetCharacterIDs) {
        this.accessToken = Preconditions.checkNotNull(accessToken);
        if (targetCharacterIDs.size() < 1) {
            throw new IllegalArgumentException("Third parameter to CSPACostRequest must be a list of one or more items");
        }

        if (targetCharacterIDs.size() > 100) {
            throw new IllegalArgumentException("Third parameter to CSPACostRequest cannot have more than 100 entries");
        }

        this.sourceCharacterID = sourceCharacterID;
        this.targetCharacterIDs = targetCharacterIDs;
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public String getURL() {
        return String.format("/v4/characters/%d/cspa/", sourceCharacterID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(targetCharacterIDs);
    }

    @Override
    public TypeReference<Float> getExpectedType() {
        return new TypeReference<Float>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
