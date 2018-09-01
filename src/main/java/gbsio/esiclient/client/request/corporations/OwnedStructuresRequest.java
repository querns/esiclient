package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.corporation.OwnedStructure;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves a list of deployed Upwell structures owned by a corporation.
 */
final public class OwnedStructuresRequest implements GetListRequest<OwnedStructure, ImmutableList<OwnedStructure>>, I18Nable {
    private final int corporationID;
    private final String accessToken;
    private final Language language;

    /**
     * Creates a request with the default language of en-us.
     *
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a member of the
     *                    corporation with Station Manager or Director roles
     */
    public OwnedStructuresRequest(final int corporationID, final String accessToken) {
        this(corporationID, accessToken, null);
    }

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to a member of the
     *                    corporation with Station Manager or Director roles
     * @param language the language to return results as
     */
    @SuppressWarnings("WeakerAccess")
    public OwnedStructuresRequest(final int corporationID, final String accessToken, final Language language) {
        this.corporationID = corporationID;
        this.accessToken = accessToken;
        this.language = language;
    }

    @Override
    public String getURL() {
        return String.format("/v2/corporations/%d/structures/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<OwnedStructure>> getExpectedType() {
        return new TypeReference<ImmutableList<OwnedStructure>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
